package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectDeleteServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDeleteServiceImplTest {

    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private ProjectDeleteServiceImpl projectDeleteService;

    @Test
    public void deleteProjectById() {

        ProjectDTO projectDTO = ProjectDTO.builder().id(2).build();
        Mockito.when(restTemplateMock
                .getForEntity("http://localhost8081/projects/{id}", ProjectDTO.class))
                .thenReturn(new ResponseEntity<>(projectDTO, HttpStatus.OK));

        ProjectDeleteServiceImpl projectDeleteService = new ProjectDeleteServiceImpl(restTemplateMock);
        projectDeleteService.deleteByProjectId(2);
        //assertEquals(HttpStatus.NO_CONTENT, projectDeleteService.);
        //assertEquals(projectDeleteService, true);
    }

//    @Test
//    public void deleteByProjectId_success() {
//
//        //setup
//        Project project = Project.builder().id(2).build();
//        when(projectRepositoryMock.findById(2)).thenReturn(Optional.of(project));
//
//        //call method under test.
//        ProjectDeleteServiceImpl projectDeleteService =
//                new ProjectDeleteServiceImpl(projectRepositoryMock);
//        boolean result = projectDeleteService.deleteByProjectId(2);
//
//        verify(projectRepositoryMock).findById(2);
//        verify(projectRepositoryMock).deleteById(2);
//        assertEquals(result, true);
//    }


}
