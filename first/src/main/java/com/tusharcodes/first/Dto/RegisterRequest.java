package com.tusharcodes.first.Dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
