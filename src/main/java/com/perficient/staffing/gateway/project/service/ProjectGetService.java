package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;

import java.util.List;

public interface ProjectGetService {

    List<ProjectDTO> findAll();

    List<ProjectDTO> findAllByBusinessUnitId(Integer businessUnitId);

    ProjectDTO findProjectById(Integer id);
}
