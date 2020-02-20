package com.perficient.staffing.gateway.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProjectDeleteServiceImpl implements ProjectDeleteService {

    @Value("${project.ms.url}")
    public String projectUrl;

    private RestTemplate restTemplate;

    @Autowired
    public ProjectDeleteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void deleteByProjectId(Integer id) {

        String url = projectUrl + id.toString();
        log.debug("Updating project Id {} DTO is {}", id);
        restTemplate.delete(url, id);

    }
}




