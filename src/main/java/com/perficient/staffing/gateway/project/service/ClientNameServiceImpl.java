package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class ClientNameServiceImpl implements ClientNameService {

    @Value("${client.url}")
    public String clientUrl;

    private RestTemplate restTemplate;

    @Autowired
    public ClientNameServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override
    public List<ClientDTO> findDistinctByName(String name) {

        String uri = clientUrl;

        uri = uri + "?name=" + name;

        ResponseEntity<ClientDTO[]> responseEntity = restTemplate.getForEntity(uri, ClientDTO[].class);

        return responseEntity.getBody() != null ? Arrays.asList(responseEntity.getBody()) : Collections.emptyList();
    }

}




