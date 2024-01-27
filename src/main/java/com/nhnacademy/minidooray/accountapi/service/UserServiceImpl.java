package com.nhnacademy.minidooray.accountapi.service;


import com.nhnacademy.minidooray.accountapi.dto.LoginDto;
import com.nhnacademy.minidooray.accountapi.dto.UserRequestDto;
import com.nhnacademy.minidooray.accountapi.dto.UserResponseDto;
import com.nhnacademy.minidooray.accountapi.entity.User;
import com.nhnacademy.minidooray.accountapi.entity.User.UserState;
import com.nhnacademy.minidooray.accountapi.exception.UserAlreadyExistException;
import com.nhnacademy.minidooray.accountapi.exception.UserNotFoundException;
import com.nhnacademy.minidooray.accountapi.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.text.html.Option;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @Override
    @Transactional
    public boolean matches(LoginDto loginDto) {
        String userId = loginDto.getUserId();
        String password = loginDto.getUserPassword();
        return userRepository.existsByUserIdAndUserPasswordLike(userId, password);
    }

    @Override
    @Transactional
    public User register(UserRequestDto userRequestDto) {
        boolean isUserExist = userRepository.existsById(userRequestDto.getUserId());
        if (isUserExist) {
            throw new UserAlreadyExistException();
        }
        return userRepository.save(
                new User(userRequestDto.getUserId(), userRequestDto.getUserPassword(), userRequestDto.getUserEmail(),
                        UserState.JOIN
                ));

    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> getUser() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponseDto(user.getUserId(), user.getUserEmail(), user.getUserState())).collect(
                        Collectors.toList());
    }

    @Override
    public void chageState(String userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        userRepository.save(new User(userId, user.getUserPassword(), user.getUserEmail(), UserState.QUIT));

    }

    @Override
    public boolean isUserJoinState(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.filter(value -> UserState.JOIN.equals(value.getUserState())).isPresent();
    }
}
