package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.BusinessUnitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class BusinessUnitSerivceImpl implements BusinessUnitService {

    @Value("${business.unit.url}")
    public String businessUnitUrl;

    private RestTemplate restTemplate;

    @Autowired
    public  BusinessUnitSerivceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<BusinessUnitDTO> findAll() {

        ResponseEntity<BusinessUnitDTO[]> entity = restTemplate.getForEntity(businessUnitUrl, BusinessUnitDTO[].class);

        return entity.getBody() != null ? Arrays.asList(entity.getBody()) : Collections.emptyList();
    }
}
