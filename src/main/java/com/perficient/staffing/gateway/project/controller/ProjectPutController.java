package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j

@RestController
public class ProjectPutController {

    //@RequestMapping(path = "/projects/{id}", method = RequestMethod.PUT)
    @PutMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO) {


            return projectDTO;
    }
}