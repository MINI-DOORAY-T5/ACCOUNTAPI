package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.dto.UserDTO;
import com.nhnacademy.minidooray.accountapi.entity.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(String id);
    UserDTO getUserDTO(String id);
    User createUser(User user);
    void deleteUser(String id);

}