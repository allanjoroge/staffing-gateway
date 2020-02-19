package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ProjectStatusDTO;
import com.perficient.staffing.gateway.project.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProjectStatusController {

    private ProjectStatusService projectStatusService;

    @Autowired
    public ProjectStatusController(ProjectStatusService projectStatusService) {
        this.projectStatusService = projectStatusService;
    }

    @GetMapping("/project-status")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectStatusDTO> findAllProjectStatuses() {

        return projectStatusService.findAllProjectStatuses();

    }
}
