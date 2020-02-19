package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectStatusDTO;

import java.util.List;

public interface ProjectStatusService {

    List<ProjectStatusDTO> findAllProjectStatuses();

}
