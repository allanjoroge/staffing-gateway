package com.perficient.staffing.staffinggateway.controller.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perficient.staffing.gateway.project.controller.ProjectPostController;
import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectPostService;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectPostController.class)
public class ProjectPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectPostService projectPostService;

    @Test
    public void createProject() throws Exception {
        ProjectDTO projectDTO = ProjectDTO.builder().id(3000).projectName("sami").businessUnitId(5).build();
        when(projectPostService.saveProject(projectDTO)).thenReturn(projectDTO);

        ObjectMapper mapper = new ObjectMapper();
        String dtoAsString = mapper.writeValueAsString(projectDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/projects").content(dtoAsString).contentType("application/json");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(projectPostService, times(1)).saveProject(projectDTO);
        verifyNoMoreInteractions(projectPostService);
        assertEquals(HttpStatus.CREATED.value(), mockHttpServletResponse.getStatus());
    }

}
