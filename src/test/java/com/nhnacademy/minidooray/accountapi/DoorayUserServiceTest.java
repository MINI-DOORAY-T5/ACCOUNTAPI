package com.nhnacademy.minidooray.accountapi;

import com.nhnacademy.minidooray.accountapi.domain.User;
import com.nhnacademy.minidooray.accountapi.repository.UserRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DoorayUserServiceTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void testStudentRepository() {
        //given
        User zbum = new User("1", "pw", "@", Status.active);
        userRepository.save(zbum);
        //when
        Optional<User> actual = userRepository.findById("1");
        //then
        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(zbum);
    }
}
