package com.perficient.staffing.gateway.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ProjectDeleteServiceImpl implements ProjectDeleteService {

    private RestTemplate restTemplate;

    public static final String PROJECTS_MS_URL = "http://localhost:8081/projects";

    @Autowired
    public ProjectDeleteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void deleteByProjectId(Integer id) {

        String url = PROJECTS_MS_URL + id.toString();

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());
        restTemplate.delete(url, params);
    }

}




