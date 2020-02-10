package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.service.ProjectDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectDeleteController {

    private ProjectDeleteService projectDeleteService;

    @Autowired
    public ProjectDeleteController(ProjectDeleteService projectDeleteService) {
        this.projectDeleteService = projectDeleteService;
    }


    @DeleteMapping
    @RequestMapping(path = "/projects/{id}"/*, method = RequestMethod.DELETE*/)
    public void deleteByProjectId(@PathVariable Integer id) {

        try {
            projectDeleteService.deleteByProjectId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


//public ResponseEntity<HttpStatus> deleteByProjectId(@PathVariable Integer id) {
//
//        boolean result = projectDeleteService.deleteByProjectId(id);
//        if (result) return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//        else return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);