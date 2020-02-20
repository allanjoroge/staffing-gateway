package com.perficient.staffing.gateway.project.client;

import com.perficient.staffing.gateway.project.dto.ProjectStatusDTO;
import com.perficient.staffing.gateway.project.dto.ProjectTypeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url= "${project.url}", name = "project")
public interface ProjectClient {

    @GetMapping("/project-types")
    //Created a method called getProjectTypes that returns a List of ProjectDTOs
    List<ProjectTypeDTO> getProjectTypes();

    @GetMapping("/project-status")
    List<ProjectStatusDTO> getProjectStatuses();


}


