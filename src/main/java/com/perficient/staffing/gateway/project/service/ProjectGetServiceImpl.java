package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectGetServiceImpl implements ProjectGetService {

    public static final String  PROJECT_MS_URL = "http://localhost:8081/projects/";

    private RestTemplate restTemplate;

    @Autowired
    public ProjectGetServiceImpl(RestTemplate restTemplate)   {
        this.restTemplate = restTemplate;
    }

    //make call to localhost:8081/projects with restTemplate
    @Override
    public List<ProjectDTO> search(Integer businessUnitId) {

        String uri = PROJECT_MS_URL;

        if (businessUnitId != null) {
            uri = uri + "?businessUnitId=" + businessUnitId;
        }

        ResponseEntity<ProjectDTO[]> entity = restTemplate.getForEntity(uri,
                ProjectDTO[].class);

        return entity.getBody() != null ? Arrays.asList(entity.getBody()) : Collections.emptyList();
    }

    @Override
    public ProjectDTO findProjectById(Integer id) {

         ProjectDTO project = restTemplate.getForObject(PROJECT_MS_URL + id,
                ProjectDTO.class);

        return project;
    }
}
