package com.perficient.staffing.gateway.project.controller;

import com.perficient.staffing.gateway.project.dto.ClientDTO;
import com.perficient.staffing.gateway.project.service.ClientNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientNameController {

    private ClientNameService clientNameService;

    @Autowired
    ClientNameController(ClientNameService clientNameService) {
        this.clientNameService = clientNameService;
    }

    @GetMapping("/client")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDTO> findByDistinctByName(@RequestParam @Nullable String name) {

        return clientNameService.findDistinctByName(name);
    }
}
