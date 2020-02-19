package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.client.ProjectClient;
import com.perficient.staffing.gateway.project.dto.ProjectStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectStatusServiceImpl implements ProjectStatusService{
    private ProjectClient projectClient;

    @Autowired
    public ProjectStatusServiceImpl (ProjectClient projectClient){
        this.projectClient = projectClient;
    }

    @Override
    public List<ProjectStatusDTO> findAllProjectStatuses() {

        return projectClient.getProjectStatuses();
    }
}
