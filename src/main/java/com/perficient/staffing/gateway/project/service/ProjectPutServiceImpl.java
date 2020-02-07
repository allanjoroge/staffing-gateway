package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;


import java.util.Arrays;

@Service
public class ProjectPutServiceImpl implements ProjectPutService {

    private RestTemplate restTemplate;

    @Autowired
    public ProjectPutServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @PutMapping("/projects/{id}")
    public ProjectDTO updateProject(ProjectDTO projectDTO) {

        final String uri = "http://localhost:8081/projects/{id}";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ProjectDTO> entity = new HttpEntity<>(projectDTO, headers);

        return restTemplate.exchange(
                uri, HttpMethod.PUT, entity, ProjectDTO.class).getBody();

    }
}

//        ResponseEntity<ProjectDTO> entity = restTemplate.put(uri,
//                ProjectDTO[].class, );
//
//        return entity.getBody() != null? Arrays.asList(entity.getBody()) : Collections.emptyList();

//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<ProjectDTO> entity = new HttpEntity<ProjectDTO>(projectDTO,headers);
//
//        return restTemplate.exchange(
//                uri , HttpMethod.PUT, entity, ProjectDTO.class).getBody();

        //return restTemplate.put ( uri, updateProject(projectDTO), projectDTO.getId(id));
        //return projectDTO;

