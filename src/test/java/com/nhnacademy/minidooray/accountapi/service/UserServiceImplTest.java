package com.nhnacademy.minidooray.accountapi.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nhnacademy.minidooray.accountapi.dto.LoginDto;
import com.nhnacademy.minidooray.accountapi.dto.UserIdOnly;
import com.nhnacademy.minidooray.accountapi.dto.UserRequestDto;
import com.nhnacademy.minidooray.accountapi.entity.User;
import com.nhnacademy.minidooray.accountapi.exception.UserAlreadyExistException;
import com.nhnacademy.minidooray.accountapi.exception.UserNotFoundException;
import com.nhnacademy.minidooray.accountapi.repository.UserRepository;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMatches() {
        when(userRepository.existsByUserIdAndUserPasswordLike("user", "password")).thenReturn(true);

        boolean matches = userService.matches(new LoginDto("user", "password"));
        assertThat(matches).isTrue();
    }

    @Test
    public void testRegister() {
        when(userRepository.existsById("user")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        UserRequestDto userRequestDto = new UserRequestDto("user", "password", "email@example.com");
        User user = userService.register(userRequestDto);

        assertThat(user).isNotNull();
        assertThat(user.getUserId()).isEqualTo(userRequestDto.getUserId());
        assertThat(user.getUserPassword()).isEqualTo(userRequestDto.getUserPassword());
        assertThat(user.getUserEmail()).isEqualTo(userRequestDto.getUserEmail());
    }

    @Test
    public void testRegister_UserAlreadyExists() {
        when(userRepository.existsById("user")).thenReturn(true);

        assertThatThrownBy(() -> userService.register(new UserRequestDto("user", "password", "email@example.com")))
                .isInstanceOf(UserAlreadyExistException.class);
    }

    @Test
    public void testChangeState() {
        User user = new User("user", "password", "email@example.com", User.UserState.JOIN);
        when(userRepository.findById("user")).thenReturn(Optional.of(user));

        userService.chageState("user");
        verify(userRepository).save(any(User.class));
    }

    @Test
    public void testChangeState_UserNotFound() {
        when(userRepository.findById("user")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.chageState("user"))
                .isInstanceOf(UserNotFoundException.class);
    }

    @Test
    public void testIsUserJoinState() {
        User user = new User("user", "password", "email@example.com", User.UserState.JOIN);
        when(userRepository.findById("user")).thenReturn(Optional.of(user));

        boolean isJoin = userService.isUserJoinState("user");
        assertThat(isJoin).isTrue();
    }

    @Test
    public void testFindUserNameOnlyAll() {
        when(userRepository.findUserNameOnlyAll()).thenReturn(Collections.singletonList(new UserIdOnly("user")));

        assertThat(userService.findUserNameOnlyAll()).hasSize(1);
    }
}