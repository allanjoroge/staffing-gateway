package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectGetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ProjectGetController {


    private ProjectGetService projectGetService;

    @Autowired
    public ProjectGetController(ProjectGetService projectGetService) {
        this.projectGetService = projectGetService;
    }

    @GetMapping("/projects")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectDTO> findAllProjects(@RequestParam @Nullable Integer businessUnitId) {

        if (businessUnitId==null){

            return projectGetService.findAll();
        }
        return projectGetService.findAllByBusinessUnitId(businessUnitId);
    }

    @GetMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO findProjectById(@PathVariable Integer id) {

        return null;
    }
}
