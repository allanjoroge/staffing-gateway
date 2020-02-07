package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectPostService;
import com.perficient.staffing.gateway.project.service.ProjectPostServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = ProjectPostServiceImpl.class)
public class ProjectPostServiceImplTest {


    @Mock
    private RestTemplate restTemplateMock;

    @Autowired
    private ProjectPostService projectPostServiceMock;


    @Test
    public void saveProject() throws Exception {


        //Setup

        ProjectDTO projectDTO = ProjectDTO.builder().projectName("John").build();
        when(restTemplateMock.getForEntity("http://localhost/projects", ProjectDTO.class)).thenReturn(new ResponseEntity(projectDTO, HttpStatus.CREATED));

  //      ProjectDTO createProject = projectDTO.getProjectName();
    //    assertEquals(projectDTO, createProject);
    }
}


//    when(restTemplateMock.getForEntity("http://localhost/projects", ProjectDTO .class)).thenReturn(new ResponseEntity(projectDTO,HttpStatus.CREATED));
//        when(projectPostServiceImpl.saveProject(projectDTO)).thenReturn(projectDTO);
//
//        ProjectPostServiceImpl projectPostService=new ProjectPostServiceImpl(restTemplateMock);
//        projectPostService.saveProject(projectDTO);
//
//        //
//
//        }
     //   }
