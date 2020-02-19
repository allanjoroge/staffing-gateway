package com.perficient.staffing.staffinggateway.controller.test;

import com.perficient.staffing.gateway.project.controller.ClientNameController;
import com.perficient.staffing.gateway.project.dto.ClientDTO;
import com.perficient.staffing.gateway.project.service.ClientNameService;
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
@WebMvcTest(value = ClientNameController.class)
public class ClientNameControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientNameService clientNameService;

    @Test
    public void findDistinctByName() throws Exception {

        //Setting up the mock
        List<ClientDTO> clientDTOS = new ArrayList<>();
        clientDTOS.add(ClientDTO.builder().name("Zava").build());
        when(clientNameService.findDistinctByName("Zava")).thenReturn(clientDTOS);

        //building request and executing it
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/client?name=Zava");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //Verify interactions with mock
        verify(clientNameService, times(1)).findDistinctByName("Zava");
        //verifyNoInteractions(clientNameService);
        assertEquals(HttpStatus.OK.value(),response.getStatus());

    }


    }

