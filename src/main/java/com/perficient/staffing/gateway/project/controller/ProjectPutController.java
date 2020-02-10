package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProjectPutController {

    @PutMapping(value = "/projects/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO) {

        return projectDTO;
    }
}