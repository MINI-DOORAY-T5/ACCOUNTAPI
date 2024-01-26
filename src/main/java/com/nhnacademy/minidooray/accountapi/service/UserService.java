package com.nhnacademy.minidooray.accountapi.service;


import com.nhnacademy.minidooray.accountapi.dto.LoginDto;
import com.nhnacademy.minidooray.accountapi.dto.UserRequestDto;
import com.nhnacademy.minidooray.accountapi.dto.UserResponseDto;
import com.nhnacademy.minidooray.accountapi.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService{

    boolean matches(LoginDto loginDto);

    User register(UserRequestDto userRequestDto);

    List<UserResponseDto> getUser();

    void changeStatus(String userId);
}
