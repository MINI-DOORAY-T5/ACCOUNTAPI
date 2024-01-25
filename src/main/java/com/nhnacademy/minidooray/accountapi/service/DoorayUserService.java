package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.domain.User;
import com.nhnacademy.minidooray.accountapi.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoorayUserService implements UserService {
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
    public User cresateUser(User user) {
        boolean present = userRepository.findById(user.getUserId()).isPresent();
        if (present) throw new IllegalStateException("already exist" + user.getUserId());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
