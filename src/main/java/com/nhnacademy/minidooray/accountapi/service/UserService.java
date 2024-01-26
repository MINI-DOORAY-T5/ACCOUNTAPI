package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.entity.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(String id);
    User createUser(User user);
    void deleteUser(String id);

}