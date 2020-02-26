package com.perficient.staffing.staffinggateway.service;


import com.perficient.staffing.gateway.project.dto.BusinessUnitDTO;
import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectPutServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProjectPutServiceImplTest {

    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private ProjectPutServiceImpl projectPutService;

    @Test
    public void updateProject() {

        ProjectDTO projectDTO = ProjectDTO.builder().id(5).businessUnit(BusinessUnitDTO.builder().id(4).build()).projectName("John").build();

        ArgumentCaptor<String> uriCaptor = ArgumentCaptor.forClass(String.class);
        projectPutService.updateProject(projectDTO);

        verify(restTemplateMock, times(1)).put(uriCaptor.capture(), any());
        String actualUri = uriCaptor.getValue();
        assertThat(actualUri, is(projectPutService.projectUrl + 5));

    }
}
