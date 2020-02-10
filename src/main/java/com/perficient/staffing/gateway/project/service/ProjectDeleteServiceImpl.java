package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class ProjectDeleteServiceImpl implements ProjectDeleteService {

    private RestTemplate restTemplate;

    @Autowired
    public ProjectDeleteServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    @DeleteMapping("/projects/{id}")
    public boolean deleteByProjectId(Integer id) {
        Optional<ProjectDTO> projectDTO = restTemplate.delete;

        if (projectDTO.isPresent()) {
            restTemplate.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}




