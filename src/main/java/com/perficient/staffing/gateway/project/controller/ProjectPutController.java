package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectPutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class ProjectPutController {

    private ProjectPutService projectPutService;

    @Autowired
    public ProjectPutController(ProjectPutService projectPutService) {
        this.projectPutService = projectPutService;
    }

    @PutMapping(value="/projects/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO) {

        return projectPutService.updateProject(projectDTO);
    }
}