package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;


import java.util.Arrays;

@Slf4j
@Service
public class ProjectPutServiceImpl implements ProjectPutService {

    public static final String  PROJECT_MS_URL = "http://localhost:8081/projects/";

    private RestTemplate restTemplate;

    @Autowired
    public ProjectPutServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void updateProject(ProjectDTO projectDTO) {

        String url = PROJECT_MS_URL + projectDTO.getId();

        log.debug("Updating project Id {} DTO is {}", projectDTO.getId(), projectDTO);
        restTemplate.put(url, projectDTO);

    }
}
