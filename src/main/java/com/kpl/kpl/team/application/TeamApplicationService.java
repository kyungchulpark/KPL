package com.kpl.kpl.team.application;

import com.kpl.kpl.member.domain.model.Authority;
import com.kpl.kpl.member.domain.model.Member;
import com.kpl.kpl.member.domain.repository.MemberRepository;
import com.kpl.kpl.team.domain.model.Team;
import com.kpl.kpl.team.domain.repository.TeamRepository;
import com.kpl.kpl.team.infrastructure.ImageUploader;
import com.kpl.kpl.team.presentation.request.CreateTeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamApplicationService {
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final ImageUploader imageUploader;

    @Transactional
    public void createTeam(String username, @RequestBody CreateTeamRequest createTeamRequest) {
        Member byUsername = findByUsername(username);
        byUsername.updateRole(Authority.OWNER);

        List<String> memberUsernames = createTeamRequest.getMembers();
        List<Member> members = membersToEntityList(memberUsernames);
        String imageUrl = imageUploader.upload(createTeamRequest.getTeamLogo());

        Team team = Team.builder()
                .name(createTeamRequest.getTeamName())
                .members(members)
                .logoImage(imageUrl)
                .build();
        teamRepository.save(team);teamRepository.save(team);

    }

    private Member findByUsername(String username) {
        return memberRepository.findByUsername(username).orElseThrow(RuntimeException::new);
    }

    private List<Member> membersToEntityList(List<String> members) {
        return members.stream().map(username -> memberRepository.findByUsername(username).orElseThrow(RuntimeException::new)).toList();
    }
}
