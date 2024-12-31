package com.kpl.kpl.member.domain.model;

import lombok.Getter;

@Getter
public enum Authority {
    USER("ROLE_USER"),
    OWNER("ROLE_OWNER"),
    MANAGER("ROLE_MANAGER"),
    ADMIN("ROLE_ADMIN");

    private String role;

    Authority(String role) {
        this.role = role;
    }
}
