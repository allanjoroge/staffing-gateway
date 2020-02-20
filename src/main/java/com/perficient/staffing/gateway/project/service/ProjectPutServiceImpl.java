package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${project.ms.url}")
    public String projectUrl;

    private RestTemplate restTemplate;

    @Autowired
    public ProjectPutServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void updateProject(ProjectDTO projectDTO) {

        String url = projectUrl + projectDTO.getId();

        log.debug("Updating project Id {} DTO is {}", projectDTO.getId(), projectDTO);
        restTemplate.put(url, projectDTO);

    }
}
