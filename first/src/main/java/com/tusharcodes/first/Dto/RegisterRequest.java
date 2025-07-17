package com.tusharcodes.first.Dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
}
