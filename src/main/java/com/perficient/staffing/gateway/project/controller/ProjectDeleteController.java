package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.service.ProjectDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectDeleteController {

    private ProjectDeleteService projectDeleteService;

    @Autowired
    public ProjectDeleteController(ProjectDeleteService projectDeleteService) {
        this.projectDeleteService = projectDeleteService;
    }


    @DeleteMapping(path = "/projects/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByProjectId(@PathVariable Integer id) {

        projectDeleteService.deleteByProjectId(id);
    }

}


