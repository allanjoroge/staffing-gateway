package com.perficient.staffing.staffinggateway.controller.test;


import com.perficient.staffing.gateway.project.controller.ProjectTypeController;
import com.perficient.staffing.gateway.project.dto.BusinessUnitDTO;
import com.perficient.staffing.gateway.project.dto.ProjectTypeDTO;
import com.perficient.staffing.gateway.project.service.ProjectTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
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
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectTypeController.class)
public class ProjectTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectTypeService projectTypeServiceMock;

    @Test
    public void findAllProjectTypes() throws Exception {

        //setup
        List<ProjectTypeDTO> projectTypeDTOS = new ArrayList<>();
        projectTypeDTOS.add(ProjectTypeDTO.builder().id(5).name("Albert").build());
        when(projectTypeServiceMock.findAllProjectTypes()).thenReturn(projectTypeDTOS);

        //build a GET request for /projects-types executing MockMvc
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/project-types");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Verify our interactions with the mocked projectTypeService, and that we received a 200 response status.
        verify(projectTypeServiceMock, times(1)).findAllProjectTypes();
        verifyNoMoreInteractions(projectTypeServiceMock);
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }


}
