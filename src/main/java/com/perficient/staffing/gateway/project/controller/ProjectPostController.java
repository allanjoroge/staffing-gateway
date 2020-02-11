package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProjectPostController {

    private ProjectPostService projectPostService;

    @Autowired
    public ProjectPostController(ProjectPostService projectPostService) {
        this.projectPostService = projectPostService;
    }

    @PostMapping("/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {

        ProjectDTO newProjectDTO = projectPostService.saveProject(projectDTO);

        log.debug("Created new project {}", newProjectDTO.toString());

        return newProjectDTO;
    }
}
