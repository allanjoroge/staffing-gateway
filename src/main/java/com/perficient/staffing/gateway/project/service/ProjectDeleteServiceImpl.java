package com.perficient.staffing.gateway.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectDeleteServiceImpl implements ProjectDeleteService {

    private RestTemplate restTemplate;

    @Autowired
    public ProjectDeleteServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean deleteByProjectId(Integer id) {
        return false;
    }

}




