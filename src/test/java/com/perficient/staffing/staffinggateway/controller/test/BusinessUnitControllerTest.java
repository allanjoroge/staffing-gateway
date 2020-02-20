package com.perficient.staffing.staffinggateway.controller.test;


import com.perficient.staffing.gateway.project.controller.BusinessUnitController;
import com.perficient.staffing.gateway.project.dto.BusinessUnitDTO;
import com.perficient.staffing.gateway.project.service.BusinessUnitService;
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
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BusinessUnitController.class)
public class BusinessUnitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessUnitService businessUnitService;

    @Test
    public void findAllBusinessUnits() throws Exception {

        //setup
        List<BusinessUnitDTO> businessUnitDTOS = new ArrayList<>();
        businessUnitDTOS.add(BusinessUnitDTO.builder().id(5).name("Albert").build());
        when(businessUnitService.findAll()).thenReturn(businessUnitDTOS);

        //build a GET request for /projects executing MockMvc
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/business-units");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Verify our interactions with the mocked projectGetService, and that we received a 200 response status.
        verify(businessUnitService, times(1)).findAll();
        verifyNoMoreInteractions(businessUnitService);
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }


}
