package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    public static final String  BUSINESS_UNIT_URL = "http://localhost:8081/project-types";


    @Override
    public List<ProjectTypeDTO> findAllProjectTypes() {
        return null;


    }
}
