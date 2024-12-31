package com.kpl.kpl.team.presentation.controller;

import com.kpl.kpl.team.application.TeamApplicationService;
import com.kpl.kpl.team.presentation.request.CreateTeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team")
public class TeamController {
    private final TeamApplicationService teamApplicationService;

    @PostMapping("/create")
    public void createTeam(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CreateTeamRequest createTeamRequest) {
        teamApplicationService.createTeam(userDetails.getUsername(), createTeamRequest);
    }

}
