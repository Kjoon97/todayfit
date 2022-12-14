package com.hackaton.todayfit.controller.api;

import com.hackaton.todayfit.dto.ResponseDto;
import com.hackaton.todayfit.dto.UserInfoDto;
import com.hackaton.todayfit.service.UserService;
import com.hackaton.todayfit.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    //회원가입
    @PostMapping("/auth/join")
    public ResponseDto<Integer> save(@RequestBody User user){
        userService.register(user); //회원가입 성공 시 1, 실패 시 -1 반환.
        System.out.println("user = " + user.getNickname());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //중복 회원 확인
    @PostMapping("/emailCheck")
    @ResponseBody
    public int emailCheck(@RequestParam("email") String email){
        return userService.emailCheck(email);
    }

    //회원 수정
    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody UserInfoDto userInfoDto){
        System.out.println("/////////////////////user = " + userInfoDto.getNickname());
        System.out.println("userInfoDto = " + userInfoDto.getRegion());
        userService.userUpdate(userInfoDto);

        //세션 등록
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userInfoDto.getEmail(), userInfoDto.getPassword()));  //Authentication 생성.
        SecurityContextHolder.getContext().setAuthentication(authentication);              //세션에 Authentication 등록.
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //지역 수정
    @PutMapping("/region")
    public ResponseDto<Integer> regionUpdate(@RequestBody UserInfoDto userInfoDto){
        userService.updateRegion(userInfoDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
