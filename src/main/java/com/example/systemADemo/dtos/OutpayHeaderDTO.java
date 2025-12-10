package com.example.systemADemo.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutpayHeaderDTO {

    private String clntnum;
    private String chrdnum;
    private String letterType;
    private LocalDateTime printDate;
    private String dataID;
    private String clntName;
    private String clntAddress;
    private LocalDateTime regDate;
    private BigDecimal benPercent;
    private String role1;
    private String role2;
    private String cownNum;
    private String cownName;
    private String notice01;
    private String notice02;
    private String notice03;
    private String notice04;
    private String notice05;
    private String notice06;
    private String claim_ID;
    private LocalDateTime tP2ProcessDate;

    public OutpayHeaderDTO(String clntnum, String chrdnum, String letterType, LocalDateTime printDate, String dataID, String clntName, String clntAddress, LocalDateTime regDate, BigDecimal benPercent, String role1, String role2, String cownNum, String cownName, String notice01, String notice02, String notice03, String notice04, String notice05, String notice06, String claim_ID, LocalDateTime tP2ProcessDate) {
        this.clntnum = clntnum;
        this.chrdnum = chrdnum;
        this.letterType = letterType;
        this.printDate = printDate;
        this.dataID = dataID;
        this.clntName = clntName;
        this.clntAddress = clntAddress;
        this.regDate = regDate;
        this.benPercent = benPercent;
        this.role1 = role1;
        this.role2 = role2;
        this.cownNum = cownNum;
        this.cownName = cownName;
        this.notice01 = notice01;
        this.notice02 = notice02;
        this.notice03 = notice03;
        this.notice04 = notice04;
        this.notice05 = notice05;
        this.notice06 = notice06;
        this.claim_ID = claim_ID;
        this.tP2ProcessDate = tP2ProcessDate;
    }

    public String getClntnum() {
        return clntnum;
    }

    public void setClntnum(String clntnum) {
        this.clntnum = clntnum;
    }

    public String getChrdnum() {
        return chrdnum;
    }

    public void setChrdnum(String chrdnum) {
        this.chrdnum = chrdnum;
    }

    public String getLetterType() {
        return letterType;
    }

    public void setLetterType(String letterType) {
        this.letterType = letterType;
    }

    public LocalDateTime getPrintDate() {
        return printDate;
    }

    public void setPrintDate(LocalDateTime printDate) {
        this.printDate = printDate;
    }

    public String getDataID() {
        return dataID;
    }

    public void setDataID(String dataID) {
        this.dataID = dataID;
    }

    public String getClntName() {
        return clntName;
    }

    public void setClntName(String clntName) {
        this.clntName = clntName;
    }

    public String getClntAddress() {
        return clntAddress;
    }

    public void setClntAddress(String clntAddress) {
        this.clntAddress = clntAddress;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public BigDecimal getBenPercent() {
        return benPercent;
    }

    public void setBenPercent(BigDecimal benPercent) {
        this.benPercent = benPercent;
    }

    public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1;
    }

    public String getRole2() {
        return role2;
    }

    public void setRole2(String role2) {
        this.role2 = role2;
    }

    public String getCownNum() {
        return cownNum;
    }

    public void setCownNum(String cownNum) {
        this.cownNum = cownNum;
    }

    public String getCownName() {
        return cownName;
    }

    public void setCownName(String cownName) {
        this.cownName = cownName;
    }

    public String getNotice01() {
        return notice01;
    }

    public void setNotice01(String notice01) {
        this.notice01 = notice01;
    }

    public String getNotice02() {
        return notice02;
    }

    public void setNotice02(String notice02) {
        this.notice02 = notice02;
    }

    public String getNotice03() {
        return notice03;
    }

    public void setNotice03(String notice03) {
        this.notice03 = notice03;
    }

    public String getNotice04() {
        return notice04;
    }

    public void setNotice04(String notice04) {
        this.notice04 = notice04;
    }

    public String getNotice05() {
        return notice05;
    }

    public void setNotice05(String notice05) {
        this.notice05 = notice05;
    }

    public String getNotice06() {
        return notice06;
    }

    public void setNotice06(String notice06) {
        this.notice06 = notice06;
    }

    public String getClaim_ID() {
        return claim_ID;
    }

    public void setClaim_ID(String claim_ID) {
        this.claim_ID = claim_ID;
    }

    public LocalDateTime gettP2ProcessDate() {
        return tP2ProcessDate;
    }

    public void settP2ProcessDate(LocalDateTime tP2ProcessDate) {
        this.tP2ProcessDate = tP2ProcessDate;
    }

    @Override
    public String toString() {
        return "OutpayHeaderDTO{" +
                ", clntnum='" + clntnum + '\'' +
                ", chrdnum='" + chrdnum + '\'' +
                ", letterType='" + letterType + '\'' +
                ", printDate=" + printDate +
                ", dataID='" + dataID + '\'' +
                ", clntName='" + clntName + '\'' +
                ", clntAddress='" + clntAddress + '\'' +
                ", regDate=" + regDate +
                ", benPercent=" + benPercent +
                ", role1='" + role1 + '\'' +
                ", role2='" + role2 + '\'' +
                ", cownNum='" + cownNum + '\'' +
                ", cownName='" + cownName + '\'' +
                ", notice01='" + notice01 + '\'' +
                ", notice02='" + notice02 + '\'' +
                ", notice03='" + notice03 + '\'' +
                ", notice04='" + notice04 + '\'' +
                ", notice05='" + notice05 + '\'' +
                ", notice06='" + notice06 + '\'' +
                ", claim_ID='" + claim_ID + '\'' +
                ", tP2ProcessDate=" + tP2ProcessDate +
                '}';
    }
}
