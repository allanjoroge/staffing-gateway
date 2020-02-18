package com.perficient.staffing.gateway.project.service;

import com.perficient.staffing.gateway.project.dto.ClientDTO;

import java.util.List;

public interface ClientNameService {

    List<ClientDTO> findDistinctByName(String name);
}
