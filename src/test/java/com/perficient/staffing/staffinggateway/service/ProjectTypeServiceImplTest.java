package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.client.ProjectClient;
import com.perficient.staffing.gateway.project.dto.ProjectTypeDTO;
import com.perficient.staffing.gateway.project.service.ProjectTypeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProjectTypeServiceImplTest {

    @Mock
    private ProjectClient projectClientMock;

    @InjectMocks
    private ProjectTypeServiceImpl projectTypeService;


    @Test
    public void findAllProjectTypes(){

        projectTypeService.findAllProjectTypes();
        verify(projectClientMock, times(1)).getProjectTypes();

    }
}
