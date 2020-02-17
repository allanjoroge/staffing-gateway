package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.BusinessUnitDTO;

import java.util.List;

public interface BusinessUnitService {

    List<BusinessUnitDTO> findAll();
}
