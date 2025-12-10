package com.example.systemADemo.service;

import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public interface FileService {

    void makeDirectory(String directory);

    void moveFile(Path source, Path destination);
}
