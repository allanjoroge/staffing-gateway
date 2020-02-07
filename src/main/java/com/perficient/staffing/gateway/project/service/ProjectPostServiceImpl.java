package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Service
public class ProjectPostServiceImpl implements ProjectPostService {


    private RestTemplate restTemplate;

    @Autowired
    public ProjectPostServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override
    @PostMapping("/projects")
    public ProjectDTO saveProject(ProjectDTO projectDTO) {

        ProjectDTO dto = restTemplate.postForObject("http://localhost:8081/projects", projectDTO, ProjectDTO.class);

        log.debug("Created new project {} ", dto);

        return dto;
    }
}

