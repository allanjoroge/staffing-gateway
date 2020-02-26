package com.perficient.staffing.gateway.project.dto;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private String accountDeveloper;
    private String comments;
    private Date endDate;
    private String engagementDirector;
    private Integer id;
    private String projectName;
    private Date startDate;
    private Integer travelFlag;
    private BusinessUnitDTO businessUnit;
    private ProjectTypeDTO projectType;
    private ProjectStatusDTO projectStatus;
    private ClientDTO client;
}
