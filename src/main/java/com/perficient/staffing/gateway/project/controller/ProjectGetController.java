package com.perficient.staffing.gateway.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProjectGetController {

    @GetMapping("/projects")
    @ResponseStatus(HttpStatus.OK)
    public String getAllProjects(@RequestParam @Nullable Integer businessUnitId) {

        log.debug("Getting all projects for business unit {}", businessUnitId);

        return "business unit is " + businessUnitId;

    }


}
