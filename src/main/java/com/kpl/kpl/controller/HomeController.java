package com.kpl.kpl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "esports-home"; // templates 폴더에 있는 index.html 반환
    }

    @GetMapping("/esports-post")
    public String showPostPage() {
        return "esports-post"; // 타임리프 템플릿 이름 (확장자 .html 제외)
    }


}
