package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.client.ProjectClient;
import com.perficient.staffing.gateway.project.service.ProjectStatusServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProjectStatusServiceImplTest {

    @Mock
    private ProjectClient projectClientMock;

    @InjectMocks
    private ProjectStatusServiceImpl projectStatusServiceMock;

    @Test
    public void findAllProjectStatuses() {

        projectStatusServiceMock.findAllProjectStatuses();

        verify(projectClientMock, times(1)).getProjectStatuses();

    }
}
