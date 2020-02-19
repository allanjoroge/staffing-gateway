package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ProjectTypeDTO;
import com.perficient.staffing.gateway.project.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProjectTypeController {

    private ProjectTypeService projectTypeService;

    @Autowired
    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @GetMapping("/project-types")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectTypeDTO> findAllProjectTypes(){

       return projectTypeService.findAllProjectTypes();

    }

}
