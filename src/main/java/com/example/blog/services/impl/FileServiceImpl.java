package com.example.blog.services.impl;

import com.example.blog.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class FileServiceImpl implements FileService {
    private final static Logger LOGGER = Logger.getLogger(FileServiceImpl.class.getName());

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String fileExtension = "";

        if (originalFilename != null && originalFilename.contains(".")) {
            fileExtension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        }

        String randomID = UUID.randomUUID().toString();
        String newFileName = randomID.concat(fileExtension);

        String filePath = path + File.separator + newFileName;

        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs(); // Create directories if they don't exist
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));

        LOGGER.info("File uploaded: " + filePath);

        return newFileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        File file = new File(fullPath);

        if (!file.exists()) {
            LOGGER.warning("File not found: " + fullPath);
            throw new FileNotFoundException("File not found: " + fullPath);
        }

        return new FileInputStream(fullPath);
    }
}
