package com.tusharcodes.first.Dto;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String email;
    private String password;
}
