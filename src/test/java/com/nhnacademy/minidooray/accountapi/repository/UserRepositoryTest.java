package com.nhnacademy.minidooray.accountapi.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.nhnacademy.minidooray.accountapi.dto.UserIdOnly;
import com.nhnacademy.minidooray.accountapi.entity.User;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        User user1 = new User("user1", "password1", "user1@example.com", User.UserState.JOIN);

        // existsByUserIdAndUserPasswordLike 메서드에 대한 모의 행동 설정
        when(userRepository.existsByUserIdAndUserPasswordLike(anyString(), anyString())).thenReturn(false);
        when(userRepository.existsByUserIdAndUserPasswordLike("user1", "password1")).thenReturn(true);

        // findUserNameOnlyAll 메서드에 대한 모의 행동 설정
        when(userRepository.findUserNameOnlyAll()).thenReturn(Arrays.asList(new UserIdOnly("user1")));
    }

    @Test
    void testExistsByUserIdAndUserPasswordLike() {
        boolean exists = userRepository.existsByUserIdAndUserPasswordLike("user1", "password1");
        assertThat(exists).isTrue();

        boolean notExists = userRepository.existsByUserIdAndUserPasswordLike("nonexistent", "password");
        assertThat(notExists).isFalse();
    }

    @Test
    void testFindUserNameOnlyAll() {
        List<UserIdOnly> users = userRepository.findUserNameOnlyAll();
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getUserId()).isEqualTo("user1");
    }
}