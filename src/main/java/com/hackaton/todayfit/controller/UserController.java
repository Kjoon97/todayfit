package com.hackaton.todayfit.controller;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.dto.RegionCode;
import com.hackaton.todayfit.dto.UserInfoDto;
import com.hackaton.todayfit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ModelAttribute("regionCodes")
    public List<RegionCode> regionCodes(){
        ArrayList<RegionCode> regionCodes = new ArrayList<>();
        regionCodes.add(new RegionCode("Seoul","서울"));
        regionCodes.add(new RegionCode("Suwon","수원"));
        regionCodes.add(new RegionCode("Uijeongbu","의정부"));
        regionCodes.add(new RegionCode("Chuncheon","춘천"));
        regionCodes.add(new RegionCode("Cheongju","청주"));
        regionCodes.add(new RegionCode("Incheon","인천"));
        regionCodes.add(new RegionCode("Jeonju","전주"));
        regionCodes.add(new RegionCode("Daegu","대구"));
        regionCodes.add(new RegionCode("Daejeon","대전"));
        regionCodes.add(new RegionCode("Gwangju","광주"));
        regionCodes.add(new RegionCode("Ulsan","울산"));
        regionCodes.add(new RegionCode("Sejong","세종"));
        regionCodes.add(new RegionCode("Busan","부산"));
        regionCodes.add(new RegionCode("Jeju","제주"));
        return regionCodes;
    }

    @GetMapping("/auth/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm(@AuthenticationPrincipal PrincipalDetails principal, Model model){
        UserInfoDto user = userService.findUser(principal);
        model.addAttribute("user",user);
        return "user/updateForm";
    }

    @GetMapping("/user/updateRegion")
    public String updateRegion(@AuthenticationPrincipal PrincipalDetails principal, Model model){
        UserInfoDto user = userService.findUser((principal));
        System.out.println("user = " + user.getId());
        model.addAttribute("user",user);
        return "user/updateRegion";
    }
}
