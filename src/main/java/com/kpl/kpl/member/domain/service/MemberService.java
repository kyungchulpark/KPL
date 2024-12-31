package com.kpl.kpl.member.domain.service;

import com.kpl.kpl.member.domain.model.Authority;
import com.kpl.kpl.member.domain.model.Member;
import com.kpl.kpl.member.presentation.request.CreateMemberRequest;
import com.kpl.kpl.member.presentation.request.LoginRequest;
import com.kpl.kpl.member.presentation.request.UpdateMemberRequest;
import com.kpl.kpl.member.domain.repository.MemberRepository;
import com.kpl.kpl.member.presentation.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    // 회원가입
    @Transactional
    public void create(CreateMemberRequest createMemberRequest) {

        emailDuplicatedCheck(createMemberRequest.getEmail());
        usernameDuplicatedCheck(createMemberRequest.getUsername());

        Member member = Member.builder()
                .email(createMemberRequest.getEmail())
                .username(createMemberRequest.getUsername())
                .password(passwordEncoder.encode(createMemberRequest.getPassword()))
                .authority(Authority.USER)
                .build();

        memberRepository.save(member);
    }

    // 로그인
    public void login(LoginRequest loginRequest) {
        Member byEmail = findByEmail(loginRequest.getEmail());
        if (!passwordEncoder.matches(loginRequest.getPassword(), byEmail.getPassword())) {
            throw new RuntimeException("Email 또는 password 가 일치하지 않습니다.");
        }
    }

    // 회원정보 수정
    @Transactional
    public void update(Long userId, UpdateMemberRequest updateMemberRequest) {
        Member byId = findById(userId);
        byId.updateUsername(updateMemberRequest.getUsername());
        byId.updatePassword(passwordEncoder.encode(updateMemberRequest.getPassword()));
    }

    // 회원정보 조회
    public MemberResponse getUserInfoById(Long userId) {
        Member byId = findById(userId);
        return new MemberResponse(byId);
    }


    // 이메일 중복 체크
    private void emailDuplicatedCheck(String email) {
        if (memberRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("중복된 Email 은 사용할수 없습니다.");
        }

    }
    // PSN_ID 중복 체크
    private void usernameDuplicatedCheck(String username) {
        if (memberRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("중복된 PSN_ID 는 사용할수 없습니다.");
        }
    }

    private Member findByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(RuntimeException::new);
    }

    private Member findByUsername(String username) {
        return memberRepository.findByUsername(username).orElseThrow(RuntimeException::new);
    }

    private Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
