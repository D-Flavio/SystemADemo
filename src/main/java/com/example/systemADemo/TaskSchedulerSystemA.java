package com.example.systemADemo;

import com.example.systemADemo.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

@Component
public class TaskSchedulerSystemA {

    private static final Logger logger = LoggerFactory.getLogger(TaskSchedulerSystemA.class);

    @Autowired
    private FileService fileService;

    private static final String desktopPath = System.getProperty("user.home") + "/Desktop";

    @Scheduled(cron = "0 0 12 * * MON-FRI", zone = "Europe/Paris")
    public void doTask() {
        logger.info("Start doTask");
        fileService.makeDirectory("SystemAExports");
        fileService.moveFile(Paths.get(desktopPath + "/tmp/CUSTCOMP01.txt"), Paths.get(desktopPath + "/SystemAExports/CUSTCOMP01.txt"));
        fileService.moveFile(Paths.get(desktopPath + "/tmp/OUTPH_CUP_20200204_1829.TXT"), Paths.get(desktopPath + "/SystemAExports/OUTPH_CUP_20200204_1829.TXT"));
        fileService.moveFile(Paths.get(desktopPath + "/tmp/ZTPSPF.TXT"), Paths.get(desktopPath + "/SystemAExports/ZTPSPF.TXT"));
        logger.info("End doTask");
    }
}
