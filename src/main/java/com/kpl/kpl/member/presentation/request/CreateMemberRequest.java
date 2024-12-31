package com.kpl.kpl.member.presentation.request;

import lombok.Data;

@Data
public class CreateMemberRequest {
    private String email;
    private String username;
    private String password;
}
