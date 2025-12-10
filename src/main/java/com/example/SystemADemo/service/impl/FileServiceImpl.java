package com.example.SystemADemo.service.impl;

import com.example.SystemADemo.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceImpl implements FileService {

    private static final String desktopPath = System.getProperty("user.home") + "/Desktop";

    @Override
    public void makeDirectory(String fileName) {
        File directory = new File(desktopPath + "/" + fileName);

        if (!directory.exists()){
            directory.mkdirs();
        }
    }

    @Override
    public void moveFile(Path source, Path destination) {
        Path temp = null;
        try {
            temp = Files.move(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(temp != null) {
            System.out.println("File moved successfully");
        }
        else {
            System.out.println("Failed to move the file");
        }
    }
}
