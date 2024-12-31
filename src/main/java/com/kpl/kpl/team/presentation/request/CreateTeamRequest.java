package com.kpl.kpl.team.presentation.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreateTeamRequest {
    private String teamName;
    private MultipartFile teamLogo;
    private List<String> members;
}
