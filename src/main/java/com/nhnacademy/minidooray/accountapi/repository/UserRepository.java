package com.nhnacademy.minidooray.accountapi.repository;

import com.nhnacademy.minidooray.accountapi.dto.UserIdOnly;
import com.nhnacademy.minidooray.accountapi.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUserIdAndUserPasswordLike(String userId, String userPassword);

    @Query("select new com.nhnacademy.minidooray.accountapi.dto.UserIdOnly(u.userId) from User u where u.userState = 'JOIN'")
    List<UserIdOnly> findUserNameOnlyAll();
}
