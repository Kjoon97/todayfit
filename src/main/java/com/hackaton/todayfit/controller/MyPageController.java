package com.hackaton.todayfit.controller;

import com.hackaton.todayfit.repository.ClothCheckRepository;
import com.hackaton.todayfit.service.MyClothService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final ClothCheckRepository clothCheckRepository;
    private final MyClothService myClothService;

    @GetMapping("/my-page")
    public String myPage(){
        return "myPage";
    }


}
