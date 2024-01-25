package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.domain.User;
import java.util.List;
import org.springframework.scheduling.support.SimpleTriggerContext;

public interface UserService {

    List<User> getUsers();

    // 회원을 생성
    User cresateUser(User user);

    // 회원1명의 정보를 조회
    // todo 회원 정보를 제공합니다.
    User getUser(String id);

    // 회원 삭제
    void deleteUser(String id);

    //todo 회원의 상태(가입,탈퇴,휴먼)를 관리(cud)합니다.


}