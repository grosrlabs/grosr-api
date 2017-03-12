package com.grosr.api.web.controllers.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by grosr on 3/7/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/api/v1/me").header("token","eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJncm9zci5hcGkiLCJhZG1pbiI6dHJ1ZSwianRpIjoiYWRtaW4ifQ.ZpAtR7s886WBKqwazdnHKTK0s272kWzxo-tD-NnX4ZY"))
                .andDo(print()).andExpect(status().isOk());
    }

}
