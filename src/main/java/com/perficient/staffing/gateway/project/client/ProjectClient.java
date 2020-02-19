package com.perficient.staffing.gateway.project.client;

import com.perficient.staffing.gateway.project.dto.ProjectStatusDTO;
import com.perficient.staffing.gateway.project.dto.ProjectTypeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url="http://localhost:8081", value = "staffing")
public interface ProjectClient {

    @RequestMapping(method = RequestMethod.GET, value = "/project-types")
    //Created a method called getProjectTypes that returns a List of ProjectDTOs
    List<ProjectTypeDTO> getProjectTypes();

    @RequestMapping(method = RequestMethod.GET, value = "/project-status")
    List<ProjectStatusDTO> getProjectStatuses();


}


