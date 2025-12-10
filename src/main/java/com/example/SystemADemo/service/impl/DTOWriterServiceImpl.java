package com.example.SystemADemo.service.impl;

import com.example.SystemADemo.dtos.CustomerCompanyPolicyDTO;
import com.example.SystemADemo.dtos.OutpayHeaderDTO;
import com.example.SystemADemo.dtos.ZTPSPFDTO;
import com.example.SystemADemo.service.DTOWriterService;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DTOWriterServiceImpl implements DTOWriterService {

    private static final Logger logger = LoggerFactory.getLogger(DTOWriterServiceImpl.class);

    public void writeZTPSPFT(List<ZTPSPFDTO> list, Path destination) {
        logger.info("Writing ZTPSPFDTOs to CSV file...");
        String filename = "ZTPSPF.csv";
        String path = destination + "/" + filename;
        char separator = Character.MIN_VALUE;
        String lineEnd = "\n";

        List<String[]> lines = new ArrayList<>();
        for (ZTPSPFDTO dto : list) {
            lines.add(zTPSPFToLine(dto));
        }

        writeAllLines(lines, path, separator, lineEnd);
        logger.info("Done writing ZTPSPFDTOs to CSV file...");
    }

    public void writeOutpayHeader(List<OutpayHeaderDTO> list, Path destination) {
        logger.info("Writing OutpayHeaderDTOs to CSV file...");
        String filename = "OUTPH_CUP_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmm")) + ".csv";
        String path = destination + "/" + filename;
        char separator = ';';
        String lineEnd = ";\n";

        List<String[]> lines = new ArrayList<>();
        for (OutpayHeaderDTO dto : list) {
            lines.add(outpayHeaderToLine(dto));
        }

        writeAllLines(lines, path, separator, lineEnd);
        logger.info("Done writing OutpayHeaderDTOs to CSV file...");
    }

    public void writeCustomerCompanyPolicy(List<CustomerCompanyPolicyDTO> list, Path destination) {
        logger.info("Writing CustomerCompanyPolicyDTOs to CSV file...");
        //TODO some logic for numbering the filename
        String filename = "CUSTCOMP" + "01"  + ".csv";
        String path = destination + "/" + filename;
        char separator = '|';
        String lineEnd = "|\n";

        List<String[]> lines = new ArrayList<>();
        for (CustomerCompanyPolicyDTO dto : list) {
            lines.add(customerCompanyPolicyToLine(dto));
        }

        writeAllLines(lines, path, separator, lineEnd);
        logger.info("Done writing CustomerCompanyPolicyDTOs to CSV file...");
    }

    private String[] zTPSPFToLine(ZTPSPFDTO object) {
        String company = object.getCompany();
        String chdrNum =  object.getChdrnum();
        StringBuilder surderValue = new StringBuilder("     " + object.getSurvalue().setScale(2, RoundingMode.HALF_DOWN));
        while(surderValue.length()<15) surderValue.insert(0, " ");
        String jobUser = "K5003MT   WEEKEND1  ";
        String jobName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String jobTimeStamp = "-08.19.59.017770";

        String fixedWidthLine = company + chdrNum + surderValue + jobUser + jobName + jobTimeStamp;

        return new String[] {fixedWidthLine};
    }

    private String[] outpayHeaderToLine(OutpayHeaderDTO object) {
        //TODO I couldn't figure out what comes between clntAddress and benPercent
        return new String[] {
                object.getClntnum(),
                object.getChrdnum(),
                object.getLetterType(),
                object.getPrintDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")),
                object.getDataID(),
                object.getClntName(),
                object.getClntAddress(),
                "",
                object.getBenPercent().setScale(2, RoundingMode.HALF_DOWN).toString(),
                object.getRole1(),
                object.getRole2(),
                object.getCownNum(),
                object.getCownName()};
    }

    private String[] customerCompanyPolicyToLine(CustomerCompanyPolicyDTO object) {
        return new String[] {
                object.getChdrnum(),
                object.getCownnum(),
                object.getOwnerName(),
                object.getLifcNum(),
                object.getLifcName(),
                object.getAracde(),
                object.getAgntnum(),
                object.getMailAddress()};
    }

    private static void writeAllLines(List<String[]> lines, String path, char separator, String lineEnd) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path), separator, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, lineEnd)) {
            writer.writeAll(lines);
            logger.info("Done writing all lines to CSV file...");
        } catch (IOException e) {
            logger.error("Error writing all lines to CSV file!", e);
        }
    }
}
