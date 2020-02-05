package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ProjectGetController {

    @GetMapping("/projects")
    @ResponseStatus(HttpStatus.OK)
    public <ProjectDTO> ProjectDTO findAllProjects(@RequestParam @Nullable ProjectDTO projectDTO) {
        return projectDTO;
    }




    @GetMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO findProjectById(@PathVariable Integer id) {

        return findProjectById(id);
    }
}
