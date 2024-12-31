package com.kpl.kpl.member.presentation.controller;

import com.kpl.kpl.member.presentation.request.CreateMemberRequest;
import com.kpl.kpl.member.presentation.request.LoginRequest;
import com.kpl.kpl.member.presentation.request.UpdateMemberRequest;
import com.kpl.kpl.member.domain.service.MemberService;
import com.kpl.kpl.member.presentation.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public void signup(@RequestBody CreateMemberRequest createMemberRequest) {
        memberService.create(createMemberRequest);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
        memberService.login(loginRequest);
    }

    @PostMapping("/{userId}/update")
    public void update(@PathVariable Long userId, @RequestBody UpdateMemberRequest updateMemberRequest) {
        memberService.update(userId, updateMemberRequest);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<MemberResponse> getUserInfo(@PathVariable Long userId) {
        return ResponseEntity.ok(memberService.getUserInfoById(userId));
    }

}
