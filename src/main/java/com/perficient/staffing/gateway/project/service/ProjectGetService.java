package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;

import java.util.List;

public interface ProjectGetService {

    List<ProjectDTO> search(Integer businessUnitId);

   // ProjectDTO findProjectById(Integer id);
}
