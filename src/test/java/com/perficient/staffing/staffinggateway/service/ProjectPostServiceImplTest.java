package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.config.BeanConfig;
import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectPostService;
import com.perficient.staffing.gateway.project.service.ProjectPostServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = ProjectPostServiceImpl.class)
public class ProjectPostServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RestTemplate restTemplateMock;

//    @Mock
//    private ProjectPostService projectPostServiceMock;

      @Mock
      private ProjectPostServiceImpl projectPostServiceImpl;

    @Test
    public void saveProject(){


        //Setup
        ProjectDTO projectDTO = ProjectDTO.builder().projectName("John").build();
        when(restTemplateMock.getForEntity("http://localhost/projects", ProjectDTO.class)).thenReturn(new ResponseEntity(projectDTO, HttpStatus.CREATED));
        when(projectPostServiceImpl.saveProject(projectDTO)).thenReturn(projectDTO);

        ProjectPostServiceImpl projectPostService = new ProjectPostServiceImpl(restTemplateMock);
        projectPostService.saveProject(projectDTO);

        //

//        verify(restTemplateMock).();
//        assertEquals(HttpStatus.CREATED.value(), );

    }
//        Project project = Project.builder().id(2000).projectName("Sami").accountDeveloper("Jordan").build();
//        ProjectDTO projectDTO = ProjectDTO.builder().id(2000).projectName("Sami").accountDeveloper("Jordan").build();
//        when(projectRepositoryMock.save(project)).thenReturn(project);
//        when(projectMapperMock.reverseTransform(projectDTO)).thenReturn(project);
//
//        //call method under text
//        ProjectPostServiceImpl projectPostService = new ProjectPostServiceImpl(projectRepositoryMock, projectMapperMock);
//        projectPostService.saveProject(projectDTO);
//
//        //assertions
//        verify(projectRepositoryMock).save(project);
//        verify(projectMapperMock).reverseTransform(any());
//    }
//
//
//    }


}
