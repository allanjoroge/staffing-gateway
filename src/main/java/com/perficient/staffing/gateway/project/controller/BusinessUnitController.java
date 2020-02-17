package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.BusinessUnitDTO;
import com.perficient.staffing.gateway.project.service.BusinessUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessUnitController {

    private BusinessUnitService businessUnitService;

    @Autowired
    public BusinessUnitController(BusinessUnitService businessUnitService) {
        this.businessUnitService = businessUnitService;
    }

    @GetMapping("/business-units")
    @ResponseStatus(HttpStatus.OK)
    public List<BusinessUnitDTO> findAllBusinessUnit() {

        return businessUnitService.findAll();

    }

}
