package com.example.SystemADemo.service;

import com.example.SystemADemo.dtos.CustomerCompanyPolicyDTO;
import com.example.SystemADemo.dtos.OutpayHeaderDTO;
import com.example.SystemADemo.dtos.ZTPSPFDTO;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public interface DTOWriterService {

    void writeCustomerCompanyPolicy(List<CustomerCompanyPolicyDTO> list, Path destination);

    void writeOutpayHeader(List<OutpayHeaderDTO> list, Path destination);

    void writeZTPSPFT(List<ZTPSPFDTO> list, Path destination);
}
