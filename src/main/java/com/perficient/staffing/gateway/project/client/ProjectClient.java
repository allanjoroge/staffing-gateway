package com.perficient.staffing.gateway.project.client;

import com.perficient.staffing.gateway.project.dto.ProjectTypeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url="http://localhost:8081", name = "project-types")
public interface ProjectClient {

    @RequestMapping(method = RequestMethod.GET, value = "/project-types")
    List<ProjectTypeDTO> getProjectTypes();

}
