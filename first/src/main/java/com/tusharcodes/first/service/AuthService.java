package com.tusharcodes.first.service;
import com.tusharcodes.first.Dto.RegisterRequest;
import com.tusharcodes.first.config.JwtService;
import com.tusharcodes.first.Dto.AuthRequest;
import com.tusharcodes.first.Dto.AuthResponse;
import com.tusharcodes.first.model.Role;
import com.tusharcodes.first.model.User;
import com.tusharcodes.first.repository.UserRepository;
import lombok.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class AuthService {
 private final UserRepository userRepository;
 private final PasswordEncoder passwordEncoder;
 private final JwtService jwtService;
 private final AuthenticationManager authenticationManager;

public AuthResponse register(RegisterRequest registerRequest) {
    var user=User.builder()
            .name(registerRequest.getName())
            .email(registerRequest.getEmail())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .role(Role.USER)
            .build();
    userRepository.save(user);

    String token = jwtService.generateToken(user.getEmail());

    return new AuthResponse(token);

  }
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(request.getEmail());
        return  new AuthResponse(token);
    }


}
