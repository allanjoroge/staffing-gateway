package com.perficient.staffing.staffinggateway.controller.test;

import com.perficient.staffing.gateway.project.controller.ProjectGetController;
import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectGetService;
import org.junit.jupiter.api.TestTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectGetController.class)
public class ProjectGetControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectGetService projectGetService;

    @Test
    public void verifyGetAllProjectWithNoBusinessUnitId() throws Exception {

        //setup
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        projectDTOList.add(ProjectDTO.builder().id(5).projectName("Albert").build());
        when(projectGetService.findAll()).thenReturn(projectDTOList);

        //build a GET request for /projects executing MockMvc
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projects");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Verify our interactions with the mocked projectGetService, and that we received a 200 response status.
        verify(projectGetService, times(1)).findAll();
        verifyNoMoreInteractions(projectGetService);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void verifyGetAllProjectWithBusinessUnitId() throws Exception {

        //setup
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        projectDTOList.add(ProjectDTO.builder().id(5).projectName("Albert").build());
        //when(projectGetService.findAll()).thenReturn(projectDTOList);

        //build a GET request for /projects executing MockMvc
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projects?businessUnitId=10");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Verify our interactions with the mocked projectGetService, and that we received a 200 response status.
        //verify(projectGetService, times(1)).findAll();
        //verifyNoMoreInteractions(projectGetService);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        //assertEquals("business unit is 10", response.getContentAsString());
    }

    @Test
    public void verifyGetProjectById() throws Exception {

        // Setup fake data, and tell our mocked service class how to behave.
        ProjectDTO projectDTO = ProjectDTO.builder().id(5).projectName("Albert").build();
        //when(projectGetService.findProjectById(5)).thenReturn(projectDTO);

        // Build a GET request for /projects/5, execute it using MockMvc.
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projects/5");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Verify our interactions with the mocked projectGetService, and that we received a 200 response status.
        //verify(projectGetService, times(1)).findProjectById(5);
        //verifyNoMoreInteractions(projectGetService);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("project ID is 5", response.getContentAsString());
    }

}
