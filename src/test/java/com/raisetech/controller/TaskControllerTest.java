package com.raisetech.controller;

import com.raisetech.service.TaskService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
// @TestPropertySource(locations = "classpath: test.properties")
public class TaskControllerTest {

    private MockMvc mockMvc;

    // @MockBean
    // private TaskService service;

    @Autowired
    private TaskController target;

    @BeforeEach
    public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("classpath:templates/");
        viewResolver.setSuffix(".html");

        mockMvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
    }

    @Test
    public void トップ画面の表示() throws Exception {
        mockMvc.perform(get("/task")).andExpect(status().isOk()).andExpect(view().name("task/index"));
    }

}
