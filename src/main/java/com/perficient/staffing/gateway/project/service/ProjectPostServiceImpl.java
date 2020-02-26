package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ProjectPostServiceImpl implements ProjectPostService {

    @Value("${project.ms.url}")
    public String projectUrl;

    private RestTemplate restTemplate;

    @Autowired
    public ProjectPostServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override
    @PostMapping("/projects")
    public ProjectDTO saveProject(ProjectDTO projectDTO) {

        ProjectDTO dto = restTemplate.postForObject(projectUrl, projectDTO, ProjectDTO.class);

        log.debug("Created new project {} ", dto);

        return dto;
    }
}

