package com.example.SystemADemo.service.impl;

import com.example.SystemADemo.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceImpl implements FileService {

    private static final String desktopPath = System.getProperty("user.home") + "/Desktop";

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public void makeDirectory(String fileName) {
        File directory = new File(desktopPath + "/" + fileName);

        if (!directory.exists()){
            directory.mkdirs();
            logger.info("Directory created: {}", directory.getAbsolutePath());
        } else  {
            logger.info("Directory already exists: {}", directory.getAbsolutePath());
        }
    }

    @Override
    public void moveFile(Path source, Path destination) {
        Path temp = null;
        try {
            temp = Files.move(source, destination);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        if(temp != null) {
            logger.info("Moving file from {} to {}", source, destination);
        }
        else {
            logger.error("File moving failed.");
        }
    }
}
