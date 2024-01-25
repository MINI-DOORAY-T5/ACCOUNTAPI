package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.domain.User;
import java.util.List;
import org.springframework.scheduling.support.SimpleTriggerContext;

public interface UserService {

    List<User> getUsers();

    User cresateUser(User user);

    User getUser(String id);

    void deleteUser(String id);


}