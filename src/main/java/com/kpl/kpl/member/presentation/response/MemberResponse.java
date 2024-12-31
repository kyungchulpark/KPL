package com.kpl.kpl.member.presentation.response;

import com.kpl.kpl.member.domain.model.Member;
import lombok.Data;

@Data
public class MemberResponse {
    private Long id;
    private String email;
    private String psnId;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.psnId = member.getUsername();
    }
}
