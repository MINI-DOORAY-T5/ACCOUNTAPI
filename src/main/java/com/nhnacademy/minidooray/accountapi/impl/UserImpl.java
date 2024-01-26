package com.nhnacademy.minidooray.accountapi.impl;

import com.nhnacademy.minidooray.accountapi.entity.User;
import com.nhnacademy.minidooray.accountapi.exception.UserNotFoundException;
import com.nhnacademy.minidooray.accountapi.repository.UserRepository;
import com.nhnacademy.minidooray.accountapi.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public User createUser(User user) {
        boolean present = userRepository.findById(user.getUserId()).isPresent();
        if (present) throw new UserNotFoundException();
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
