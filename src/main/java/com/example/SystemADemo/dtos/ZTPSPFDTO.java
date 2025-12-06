package com.example.SystemADemo.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ZTPSPFDTO extends BaseDTO {

    private String chdrnum;
    private BigDecimal survalue;
    private String company;
    private String currency;
    private LocalDateTime validDate;

    public ZTPSPFDTO(String chdrnum, BigDecimal survalue, String company, String currency, LocalDateTime validDate) {
        this.chdrnum = chdrnum;
        this.survalue = survalue;
        this.company = company;
        this.currency = currency;
        this.validDate = validDate;
    }

    public String getChdrnum() {
        return chdrnum;
    }

    public void setChdrnum(String chdrnum) {
        this.chdrnum = chdrnum;
    }

    public BigDecimal getSurvalue() {
        return survalue;
    }

    public void setSurvalue(BigDecimal survalue) {
        this.survalue = survalue;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getValidDate() {
        return validDate;
    }

    public void setValidDate(LocalDateTime validDate) {
        this.validDate = validDate;
    }

    @Override
    public String toString() {
        return "ZTPSPFDTO{" +
                "id='" + getId() + '\'' +
                ", chdrnum='" + chdrnum + '\'' +
                ", survalue=" + survalue +
                ", company='" + company + '\'' +
                ", currency='" + currency + '\'' +
                ", validDate=" + validDate +
                '}';
    }
}
