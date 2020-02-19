package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectGetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProjectGetServiceImplTest {

    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private ProjectGetServiceImpl projectGetService;

    @Test
    public void searchWithBusinessUnit() {

        ResponseEntity entity = new ResponseEntity<ProjectDTO[]>(HttpStatus.OK);
        when(restTemplateMock.getForEntity(anyString(), any())).thenReturn(entity);

        ArgumentCaptor<String> uriCaptor = ArgumentCaptor.forClass(String.class);

        projectGetService.search(4);

        verify(restTemplateMock, times(1)).getForEntity(uriCaptor.capture(), any());
        String actualUri = uriCaptor.getValue();

        assertThat(actualUri, is(ProjectGetServiceImpl.PROJECT_MS_URL + "?businessUnitId=4"));

    }


    @Test
    public void findByProjectId() {

         ProjectDTO projectDTO = new ProjectDTO();
        when(restTemplateMock.getForObject(anyString(), any())).thenReturn(projectDTO);

        ArgumentCaptor<String> uriCaptor = ArgumentCaptor.forClass(String.class);

        projectGetService.findProjectById(2);

        verify(restTemplateMock, times(1)).getForObject(uriCaptor.capture(), any());
        String actualUri = uriCaptor.getValue();

        assertThat(actualUri, is(ProjectGetServiceImpl.PROJECT_MS_URL + 2));

    }
}