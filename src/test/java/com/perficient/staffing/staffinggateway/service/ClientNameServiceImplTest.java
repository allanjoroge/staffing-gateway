package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.dto.ClientDTO;
import com.perficient.staffing.gateway.project.service.ClientNameServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ClientNameServiceImplTest {

    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private ClientNameServiceImpl clientNameService;

    @Test
    public void findDistinctByName() {
        ResponseEntity entity = new ResponseEntity<ClientDTO[]>(HttpStatus.OK);
        when(restTemplateMock.getForEntity(anyString(), any())).thenReturn(entity);

        ArgumentCaptor<String> uriCaptor = ArgumentCaptor.forClass(String.class);

        clientNameService.findDistinctByName("Zava");

        verify(restTemplateMock, times(1)).getForEntity(uriCaptor.capture(), any());
        String actualUri = uriCaptor.getValue();

        assertThat(actualUri, is(ClientNameServiceImpl.CLIENT_NAME_URL + "?name=Zava"));

    }
}
