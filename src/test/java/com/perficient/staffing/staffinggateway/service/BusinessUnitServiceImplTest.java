package com.perficient.staffing.staffinggateway.service;


import com.perficient.staffing.gateway.project.dto.BusinessUnitDTO;
import com.perficient.staffing.gateway.project.service.BusinessUnitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BusinessUnitServiceImplTest {

    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private BusinessUnitServiceImpl businessUnitServiceMock;

    @Test
    public void findAllBusinessUnits(){

        ResponseEntity entity = new ResponseEntity<BusinessUnitDTO[]>(HttpStatus.OK);
        when(restTemplateMock.getForEntity(businessUnitServiceMock.businessUnitUrl, BusinessUnitDTO[].class)).thenReturn(entity);

        ArgumentCaptor<String> uriCaptor = ArgumentCaptor.forClass(String.class);

        businessUnitServiceMock.findAll();

        verify(restTemplateMock, times(1)).getForEntity(uriCaptor.capture(), any());
        String actualUri = uriCaptor.getValue();

        assertThat(actualUri, is(businessUnitServiceMock.businessUnitUrl));

    }
}
