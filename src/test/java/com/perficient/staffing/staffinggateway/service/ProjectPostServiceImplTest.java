package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectPostServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProjectPostServiceImplTest {

    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private ProjectPostServiceImpl projectPostService;

    @Test
    public void saveProject() {

        ProjectDTO projectDTO = ProjectDTO.builder().id(5).businessUnitId(4).projectName("John").build();

        when(restTemplateMock.postForObject(anyString(), any(), eq(ProjectDTO.class))).thenReturn(projectDTO);

        ProjectDTO dto = projectPostService.saveProject(projectDTO);
        assertNotNull(dto);

        verify(restTemplateMock, times(1)).postForObject(anyString(), any(), eq(ProjectDTO.class));

    }
}

