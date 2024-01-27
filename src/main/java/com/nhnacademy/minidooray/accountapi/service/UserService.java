package com.nhnacademy.minidooray.accountapi.service;


import com.nhnacademy.minidooray.accountapi.dto.LoginDto;
import com.nhnacademy.minidooray.accountapi.dto.UserIdOnly;
import com.nhnacademy.minidooray.accountapi.dto.UserRequestDto;
import com.nhnacademy.minidooray.accountapi.dto.UserResponseDto;
import com.nhnacademy.minidooray.accountapi.entity.User;
import java.util.List;

public interface UserService{

    boolean matches(LoginDto loginDto);

    User register(UserRequestDto userRequestDto);


    void chageState(String userId);

    boolean isUserJoinState(String userId);

    List<UserIdOnly> findUserNameOnlyAll();
}
