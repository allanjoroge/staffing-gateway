package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

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

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ProjectDTO> entity = new HttpEntity<ProjectDTO>(projectDTO,headers);

        return restTemplate.exchange(
                "http://localhost:8081/projects", HttpMethod.POST, entity, ProjectDTO.class).getBody();
    }
}

