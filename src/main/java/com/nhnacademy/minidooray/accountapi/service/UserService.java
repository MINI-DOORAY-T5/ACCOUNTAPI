package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.entity.User;
import java.util.List;

public interface UserService {
    User getUser(String id);
    User createUser(User user);



//    List<User> getUsers();
//    void deleteUser(String id);


}