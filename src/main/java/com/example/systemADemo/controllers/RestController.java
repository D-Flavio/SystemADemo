package com.example.systemADemo.controllers;

import com.example.systemADemo.service.DTOWriterService;
import com.example.systemADemo.service.FileService;
import com.example.systemADemo.dtos.CustomerCompanyPolicyDTO;
import com.example.systemADemo.dtos.OutpayHeaderDTO;
import com.example.systemADemo.dtos.ZTPSPFDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private DTOWriterService dtoWriterService;

    @Autowired
    private FileService fileService;

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    private static final String desktopPath = System.getProperty("user.home") + "/Desktop";

    @GetMapping("/move")
    public void startMove() {
        logger.info("Start move");
        fileService.makeDirectory("SystemAExports");
        fileService.moveFile(Paths.get(desktopPath + "/tmp/CUSTCOMP01.txt"), Paths.get(desktopPath + "/SystemAExports/CUSTCOMP01.txt"));
        fileService.moveFile(Paths.get(desktopPath + "/tmp/OUTPH_CUP_20200204_1829.TXT"), Paths.get(desktopPath + "/SystemAExports/OUTPH_CUP_20200204_1829.TXT"));
        fileService.moveFile(Paths.get(desktopPath + "/tmp/ZTPSPF.TXT"), Paths.get(desktopPath + "/SystemAExports/ZTPSPF.TXT"));
        logger.info("End move");
    }

    @GetMapping("/csv")
    public void startExportToCSV() {
        logger.info("Start exportToCSV");
        Path destination = Paths.get(desktopPath + "/SystemAExports");
        fileService.makeDirectory("SystemAExports");
        dtoWriterService.writeCustomerCompanyPolicy(generateCustomerCompanyPolicies(), destination);
        dtoWriterService.writeOutpayHeader(generateOutpayHeaders(), destination);
        dtoWriterService.writeZTPSPFT(generateZTPSPFs(), destination);
        logger.info("End exportToCSV");
    }

    private List<CustomerCompanyPolicyDTO> generateCustomerCompanyPolicies() {
        List<CustomerCompanyPolicyDTO> list = new ArrayList<>();

        list.add(new CustomerCompanyPolicyDTO(
                "86000019",
                "76000018",
                "Szegedi István",
                "76000018",
                "Balatoni Gábor",
                "00X",
                "11111",
                "6436 Budapest Rév u. 27."));

        list.add(new CustomerCompanyPolicyDTO(
                "86000092",
                "76000091",
                "Vakula Péter",
                "76000199",
                "Vörös János",
                "00X",
                "11111",
                "2356 Baja Szent Miklós u. 10/b III. 10."));

        list.add(new CustomerCompanyPolicyDTO(
                "86000019",
                "76000018",
                "Horváth Domokos",
                "76000223",
                "Harcos Bálint",
                "00X",
                "11111",
                "2346 Tokaj Kassai u. 25. IX. 36."));

        return list;
    }

    private List<OutpayHeaderDTO> generateOutpayHeaders() {
        List<OutpayHeaderDTO> list = new ArrayList<>();

        list.add(new OutpayHeaderDTO(
                "20930093",
                "70027344",
                "CUP",
                LocalDateTime.now(),
                "OUTPAY",
                "Kovács Lajos",
                "2643 Budapest, Berényi út 37.",
                LocalDateTime.now(),
                BigDecimal.valueOf(100),
                "OW",
                "  ",
                "20930093",
                "Bakonyi Árpád",
                "defaultNotice01",
                "defaultNotice02",
                "defaultNotice03",
                "defaultNotice04",
                "defaultNotice05",
                "defaultNotice06",
                "91-978663",
                LocalDateTime.now()));

        list.add(new OutpayHeaderDTO(
                "27327894",
                "70182719",
                "CUP",
                LocalDateTime.now(),
                "OUTPAY",
                "Nagy Tibor",
                "7546 Szeged, Rábca u. 15.",
                LocalDateTime.now(),
                BigDecimal.valueOf(100),
                "OW",
                "  ",
                "20200211",
                "Lange Nóra",
                "defaultNotice01",
                "defaultNotice02",
                "defaultNotice03",
                "defaultNotice04",
                "defaultNotice05",
                "defaultNotice06",
                "91-978663",
                LocalDateTime.now()));

        list.add(new OutpayHeaderDTO(
                "66677541",
                "71267239",
                "CUP",
                LocalDateTime.now(),
                "OUTPAY",
                "Szegedi István",
                "2467 Veszprém, Fülemüle u. 6",
                LocalDateTime.now(),
                BigDecimal.valueOf(100),
                "OW",
                "  ",
                "20200207",
                "Pintér Béla",
                "defaultNotice01",
                "defaultNotice02",
                "defaultNotice03",
                "defaultNotice04",
                "defaultNotice05",
                "defaultNotice06",
                "91-978663",
                LocalDateTime.now()));

        return list;
    }

    private List<ZTPSPFDTO> generateZTPSPFs() {
        List<ZTPSPFDTO> list = new ArrayList<>();

        list.add(new ZTPSPFDTO(
                "30052881",
                BigDecimal.valueOf(3276866.00),
                "1",
                "123",
                LocalDateTime.now()));

        list.add(new ZTPSPFDTO(
                "30026897",
                BigDecimal.valueOf(815513.00),
                "1",
                "123",
                LocalDateTime.now()));

        list.add(new ZTPSPFDTO(
                "30063155",
                BigDecimal.valueOf(0.00),
                "1",
                "123",
                LocalDateTime.now()));

        return list;
    }
}
