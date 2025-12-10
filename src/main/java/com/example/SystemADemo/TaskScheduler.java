package com.example.SystemADemo;

import com.example.SystemADemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

@Component
public class TaskScheduler {

    @Autowired
    private FileService fileService;

    private static final String desktopPath = System.getProperty("user.home") + "/Desktop";

    //cron = "0 13 * * ?", zone = "Europe/Paris"
    @Scheduled(fixedDelay = 100000)
    public void doTask() {
        fileService.makeDirectory("SystemAExports");
        fileService.moveFile(Paths.get(desktopPath + "/tmp/CUSTCOMP01.txt"), Paths.get(desktopPath + "/SystemAExports/CUSTCOMP01.txt"));
        fileService.moveFile(Paths.get(desktopPath + "/tmp/OUTPH_CUP_20200204_1829.TXT"), Paths.get(desktopPath + "/SystemAExports/OUTPH_CUP_20200204_1829.TXT"));
        fileService.moveFile(Paths.get(desktopPath + "/tmp/ZTPSPF.TXT"), Paths.get(desktopPath + "/SystemAExports/ZTPSPF.TXT"));
    }
}
