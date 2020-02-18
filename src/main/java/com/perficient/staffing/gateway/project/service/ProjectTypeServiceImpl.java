package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.client.ProjectClient;
import com.perficient.staffing.gateway.project.dto.ProjectTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    private ProjectClient projectClient;

    @Autowired
    public ProjectTypeServiceImpl (ProjectClient projectClient){
        this.projectClient = projectClient;
    }

    @Override
    public List<ProjectTypeDTO> findAllProjectTypes() {

        return projectClient.getProjectTypes();
    }
}
