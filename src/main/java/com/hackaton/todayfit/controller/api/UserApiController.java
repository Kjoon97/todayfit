package com.hackaton.todayfit.controller.api;

import com.hackaton.todayfit.dto.ResponseDto;
import com.hackaton.todayfit.service.UserService;
import com.hackaton.todayfit.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    //회원가입
    @PostMapping("/auth/join")
    public ResponseDto<Integer> save(@RequestBody User user){
        userService.register(user); //회원가입 성공 시 1, 실패 시 -1 반환.
        System.out.println("user = " + user.getNickname());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
