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
    public String getAllProjects(@RequestParam @Nullable Integer businessUnitId) {

        log.debug("Getting all projects for business unit {}", businessUnitId);

        return "business unit is " + businessUnitId;

    }

    @GetMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getProjectById(@PathVariable Integer id) {

        log.debug("Getting project with ID {}", id);

        return "project ID is " + id;

    }
}
