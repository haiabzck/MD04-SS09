package com.example.session09.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadService {
    private static final String UPLOAD_DIR = "uploads";
    public static String uploadFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            String uuid = UUID.randomUUID().toString()+ "_" +fileName;
            Path path = Paths.get(UPLOAD_DIR + "/" + uuid);
            Files.createDirectories(path.getParent());
            file.transferTo(path);
            return UPLOAD_DIR + "/" + uuid;
        } catch (IOException e) {
            throw new RuntimeException("Lỗi hệ thống khi upload file" , e);
        }
    }
}
