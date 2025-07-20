package com.tusharcodes.first.service;
import com.tusharcodes.first.config.JwtService;
import com.tusharcodes.first.Dto.AuthRequest;
import com.tusharcodes.first.Dto.AuthResponse;
import com.tusharcodes.first.Dto.RegisterRequest;
import com.tusharcodes.first.model.User;
import com.tusharcodes.first.repository.UserRepository;
import lombok.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
private final JwtService jwtService;
private final AuthenticationManager authenticationManager;

public AuthResponse register(RegisterRequest registerRequest) {
    User user=User.builder()
            .name(registerRequest.getName())
            .email(registerRequest.getEmail())
            .password(registerRequest.getPassword())
            .build();
    userRepository.save(user);
    JwtService jwtService=new JwtService();
    String token;
    token = jwtService.generateToken(user.getEmail());
    return new AuthResponse(token);
  }
    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

}
