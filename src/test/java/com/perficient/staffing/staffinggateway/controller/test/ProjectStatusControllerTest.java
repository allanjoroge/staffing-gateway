package com.perficient.staffing.staffinggateway.controller.test;

import com.perficient.staffing.gateway.project.controller.ProjectStatusController;
import com.perficient.staffing.gateway.project.dto.ProjectStatusDTO;
import com.perficient.staffing.gateway.project.service.ProjectStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectStatusController.class)
public class ProjectStatusControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectStatusService projectStatusNameServiceMock;

    @Test
    public void findAllProjectStatuses() throws Exception {

        //Setting up the mock
        List<ProjectStatusDTO> projectStatusDTOS = new ArrayList<>();
        projectStatusDTOS.add(ProjectStatusDTO.builder().id(1).name("Prospective").build());
        when(projectStatusNameServiceMock.findAllProjectStatuses()).thenReturn(projectStatusDTOS);

        //building request and executing it
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/project-status");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //Verify interactions with mock
        verify(projectStatusNameServiceMock, times(1)).findAllProjectStatuses();
        //verifyNoInteractions(clientNameService);
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
}
