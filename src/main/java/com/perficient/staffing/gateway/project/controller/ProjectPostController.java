package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.logging.Logger;

@Slf4j
@RestController
public class ProjectPostController {

//    private static final Logger logger = Logger.getLogger(String.valueOf(ProjectPostController.class));

//    @Autowired
//    public ProjectPostController(ProjectPostController projectPostService) {
//        this.projectPostController = projectPostController;
//    }

   // @PostMapping(value="/projects", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    //@ResponseStatus(HttpStatus.CREATED)
  //  public ResponseEntity<ProjectDTO> postProject(@RequestBody ProjectDTO projectDTO) throws Exception {

      // projectDTO.add(projectDTO);
       // return ResponseEntity.created(new URI("http://localhost:8081/projects/" + result.getId())).body(result);
  //  }


}
