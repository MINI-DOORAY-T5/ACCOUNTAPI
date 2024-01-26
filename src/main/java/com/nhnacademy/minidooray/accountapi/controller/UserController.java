package com.nhnacademy.minidooray.accountapi.controller;


import com.nhnacademy.minidooray.accountapi.dto.LoginDto;
import com.nhnacademy.minidooray.accountapi.dto.UserRequestDto;
import com.nhnacademy.minidooray.accountapi.dto.UserResponseDto;
import com.nhnacademy.minidooray.accountapi.entity.User;
import com.nhnacademy.minidooray.accountapi.exception.UserNotFoundException;
import com.nhnacademy.minidooray.accountapi.exception.ValidationFailedException;
import com.nhnacademy.minidooray.accountapi.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> doLogin(@RequestBody @Valid LoginDto loginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        boolean loginSuccess = userService.matches(loginDto);
        if (loginSuccess) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid UserRequestDto userRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        return userService.register(userRequestDto);
    }

    @GetMapping("/users/list")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserResponseDto>> getUser() {
        List<UserResponseDto> name = userService.getUser();
        return ResponseEntity.status(HttpStatus.OK).body(name);
    }

    @PostMapping("/users/status/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> statusChange(@PathVariable("userId") String userId){
        userService.changeStatus(userId);
        return ResponseEntity.noContent().build();
    }
}
