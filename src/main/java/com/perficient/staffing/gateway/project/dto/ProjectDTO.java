package com.perficient.staffing.gateway.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
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
