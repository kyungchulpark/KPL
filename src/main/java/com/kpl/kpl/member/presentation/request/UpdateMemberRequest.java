package com.kpl.kpl.member.presentation.request;

import lombok.Data;

@Data
public class UpdateMemberRequest {
    private String username;
    private String password;
}
