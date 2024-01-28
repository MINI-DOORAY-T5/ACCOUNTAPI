package com.nhnacademy.minidooray.accountapi.controller;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidooray.accountapi.dto.LoginDto;
import com.nhnacademy.minidooray.accountapi.dto.UserIdOnly;
import com.nhnacademy.minidooray.accountapi.dto.UserRequestDto;
import com.nhnacademy.minidooray.accountapi.entity.User;
import com.nhnacademy.minidooray.accountapi.service.UserService;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testDoLogin() throws Exception {
        LoginDto loginDto = new LoginDto("user", "password");
        when(userService.matches(any(LoginDto.class))).thenReturn(true);

        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(loginDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testCreateUser() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto("user", "password", "email@example.com");
        when(userService.register(any(UserRequestDto.class))).thenReturn(new User("user", "password", "email@example.com", User.UserState.JOIN));

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userRequestDto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetUser() throws Exception {
        when(userService.findUserNameOnlyAll()).thenReturn(Collections.singletonList(new UserIdOnly("user")));

        mockMvc.perform(get("/users/list"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("user")));
    }

    @Test
    public void testStateChange() throws Exception {
        doNothing().when(userService).chageState("user");

        mockMvc.perform(post("/users/state/user"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testIsUserJoinState() throws Exception {
        when(userService.isUserJoinState("user")).thenReturn(true);

        mockMvc.perform(get("/users/checkstate/user"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
