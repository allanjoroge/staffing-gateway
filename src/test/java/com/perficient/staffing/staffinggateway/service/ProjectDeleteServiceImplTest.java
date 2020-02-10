package com.perficient.staffing.staffinggateway.service;

import com.perficient.staffing.gateway.project.dto.ProjectDTO;
import com.perficient.staffing.gateway.project.service.ProjectDeleteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDeleteServiceImplTest {

    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private ProjectDeleteServiceImpl projectDeleteService;

    @Test
    public void deleteProjectById() {

        ProjectDTO projectDTO = ProjectDTO.builder().id(2).build();



    }

//    @Test
//    public void deleteByProjectId_success() {
//
//        //setup
//        Project project = Project.builder().id(2).build();
//        when(projectRepositoryMock.findById(2)).thenReturn(Optional.of(project));
//
//        //call method under test.
//        ProjectDeleteServiceImpl projectDeleteService =
//                new ProjectDeleteServiceImpl(projectRepositoryMock);
//        boolean result = projectDeleteService.deleteByProjectId(2);
//
//        verify(projectRepositoryMock).findById(2);
//        verify(projectRepositoryMock).deleteById(2);
//        assertEquals(result, true);
//    }


}
