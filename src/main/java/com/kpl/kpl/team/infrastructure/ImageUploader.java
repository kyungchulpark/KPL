package com.kpl.kpl.team.infrastructure;

import com.amazonaws.services.s3.AmazonS3Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class ImageUploader {

    private final AmazonS3Client s3Client;

    public String upload(MultipartFile file) {
        return "teamLogoImageUrl";
    }
}
