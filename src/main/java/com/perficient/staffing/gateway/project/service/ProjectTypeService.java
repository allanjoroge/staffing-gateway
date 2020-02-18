package com.perficient.staffing.gateway.project.service;


import com.perficient.staffing.gateway.project.dto.ProjectTypeDTO;


import java.util.List;

public interface ProjectTypeService {

    List<ProjectTypeDTO> findAllProjectTypes();
}
