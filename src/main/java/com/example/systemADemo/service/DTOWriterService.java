package com.example.systemADemo.service;

import com.example.systemADemo.dtos.CustomerCompanyPolicyDTO;
import com.example.systemADemo.dtos.OutpayHeaderDTO;
import com.example.systemADemo.dtos.ZTPSPFDTO;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public interface DTOWriterService {

    void writeCustomerCompanyPolicy(List<CustomerCompanyPolicyDTO> list, Path destination);

    void writeOutpayHeader(List<OutpayHeaderDTO> list, Path destination);

    void writeZTPSPFT(List<ZTPSPFDTO> list, Path destination);
}
