package com.tusharcodes.first.Dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
