package com.grosr.api.web.controllers.auth;

import com.grosr.api.Application;
import com.grosr.api.dto.auth.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by grosr on 3/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTests {
    @Autowired
    private MockMvc mockMvc;


//    @Test
//    public void loginShouldReturnJWTToken() throws Exception {
//
//        this.mockMvc.perform(
//                post("/api/v1/auth/login")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content("{\"username\":\"admin\",\"password\":\"admin\"}")
//                )
//                .andDo(print()).andExpect(status().isOk());
//    }

    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/api/v1/auth/logout"))
                .andDo(print()).andExpect(status().isOk());
    }
}
