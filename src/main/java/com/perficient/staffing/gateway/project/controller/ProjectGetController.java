package com.perficient.staffing.gateway.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController

public class ProjectGetController {

    @GetMapping("/projects")
    @ResponseStatus(HttpStatus.OK)
    @Autowired
    public String getAllProjects(@RequestParam @Nullable Integer businessUnitId) {
       return "business unit is " + businessUnitId;

    }


}
