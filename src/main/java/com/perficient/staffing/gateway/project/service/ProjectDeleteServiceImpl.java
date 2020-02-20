package com.perficient.staffing.gateway.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.perficient.staffing.properties.Props.PROJECTS_MS_URL;

@Service
@Slf4j
public class ProjectDeleteServiceImpl implements ProjectDeleteService {

    private RestTemplate restTemplate;

    @Autowired
    public ProjectDeleteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void deleteByProjectId(Integer id) {

        String url = PROJECTS_MS_URL + id.toString();
        log.debug("Updating project Id {} DTO is {}", id);
        restTemplate.delete(url, id);

    }
}




