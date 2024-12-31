package com.kpl.kpl.member.presentation.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
