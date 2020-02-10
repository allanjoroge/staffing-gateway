package com.perficient.staffing.staffinggateway.controller.test;

import com.perficient.staffing.gateway.project.controller.ProjectDeleteController;
import com.perficient.staffing.gateway.project.service.ProjectDeleteService;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectDeleteController.class)
public class ProjectDeleteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectDeleteService projectDeleteService;

    @Test
    public void verifyProjectDeleted() throws Exception {

        when(projectDeleteService.deleteByProjectId(4)).thenReturn(true);

        //Build a DELETE request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/projects/4");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //Verify interaction with the mocked projectDeleteService
        verify(projectDeleteService, times(1)).deleteByProjectId(4);
        verifyNoMoreInteractions(projectDeleteService);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


}



