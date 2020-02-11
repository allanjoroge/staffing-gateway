package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectDeleteServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
}

//        ArgumentCaptor<String> uriCaptor = ArgumentCaptor.forClass(String.class);
//        projectDeleteService.deleteByProjectId(2);
//
//        verify(restTemplateMock, times(1)).delete("http://localhost:8081/projects/2");
//        String actualUri = uriCaptor.getValue();
//        assertThat(actualUri, is(ProjectDeleteServiceImpl.PROJECTS_MS_URL + 2));
