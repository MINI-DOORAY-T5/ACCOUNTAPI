package com.nhnacademy.minidooray.accountapi.service;


import com.nhnacademy.minidooray.accountapi.dto.LoginDto;
import com.nhnacademy.minidooray.accountapi.dto.UserRequestDto;
import com.nhnacademy.minidooray.accountapi.dto.UserResponseDto;
import com.nhnacademy.minidooray.accountapi.entity.User;
import com.nhnacademy.minidooray.accountapi.entity.User.UserStatus;
import com.nhnacademy.minidooray.accountapi.exception.UserAlreadyExistException;
import com.nhnacademy.minidooray.accountapi.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
       return userRepository.save(new User(userRequestDto.getUserId(), userRequestDto.getUserPassword(), UserStatus.JOIN,
                userRequestDto.getUserEmail()
        ));

    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> getUser() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(user -> new UserResponseDto(user.getUserId(), user.getEmail(), user.getUserStatus())).collect(
                Collectors.toList());
    }
}
