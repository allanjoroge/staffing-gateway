package com.perficient.staffing.gateway.project.dto;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    @ToString.Exclude
    private String accountDeveloper;
    private Integer businessUnitId;
    private Integer clientId;
    private String comments;
    private Date endDate;
    private String engagementDirector;
    private Integer id;
    private String projectName;
    private Integer projectStatusId;
    private Integer projectTypeId;
    private Date startDate;
    private Integer travelFlag;
}
