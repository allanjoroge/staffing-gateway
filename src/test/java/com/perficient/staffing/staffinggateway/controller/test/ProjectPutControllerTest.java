package com.perficient.staffing.staffinggateway.controller.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perficient.staffing.gateway.project.controller.ProjectPutController;
import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectPutController.class)
public class ProjectPutControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void updateProject() throws Exception {

        //setup mock objects
        ProjectDTO projectDTO = ProjectDTO.builder().id(200).projectName("Sami").accountDeveloper("Jordan").build();
        //when(projectPutService.updateProject(projectDTO)).thenReturn(projectDTO);

        //turn dto to a json string
        ObjectMapper mapper = new ObjectMapper();
        String dtoAsString = mapper.writeValueAsString(projectDTO);

        //build a put request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/projects/200").content(dtoAsString).contentType("application/json");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

       // verify(projectPutService, times(1)).updateProject(projectDTO);
       // verifyNoMoreInteractions(projectPutService); //unexpected behaviors side effects
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

}
