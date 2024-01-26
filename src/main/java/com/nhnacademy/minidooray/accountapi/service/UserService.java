package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.entity.User;
import java.util.List;

public interface UserService {

    List<User> getUsers();

    User createUser(User user);

    User getUser(String id);

    void deleteUser(String id);


}