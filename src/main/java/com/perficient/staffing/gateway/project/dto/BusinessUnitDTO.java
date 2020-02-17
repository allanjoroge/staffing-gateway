package com.perficient.staffing.gateway.project.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessUnitDTO {

    private Integer id;
    private String name;
}