package com.perficient.staffing.staffinggateway.controller.test;

public class ProjectDeleteControllerTest {
}


//FROM MICRO SERVICES
// @RunWith(SpringRunner.class)
//@WebMvcTest(value = ProjectDeleteController.class)
//public class ProjectDeleteControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProjectDeleteService projectDeleteService;
//
//    @Test
//    public void verifyDeleteProject_success() throws Exception {
//
//        when(projectDeleteService.deleteByProjectId(4)).thenReturn(true);
//
//        //Build a DELETE request
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/projects/4");
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        //Verify interaction with the mocked projectDeleteService
//        verify(projectDeleteService, times(1)).deleteByProjectId(4);
//        verifyNoMoreInteractions(projectDeleteService);
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//    }
//
//    @Test
//    public void verifyDeleteProject_failure() throws Exception {
//
//        when(projectDeleteService.deleteByProjectId(4)).thenReturn(false);
//
//        //Build a DELETE request
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/projects/4");
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        //Verify interaction with the mocked projectDeleteService
//        verify(projectDeleteService, times(1)).deleteByProjectId(4);
//        verifyNoMoreInteractions(projectDeleteService);
//        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
//
//    }
//}