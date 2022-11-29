package com.hackaton.todayfit.controller;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.model.CheckCloth;
import com.hackaton.todayfit.model.Item;
import com.hackaton.todayfit.repository.ClothCheckRepository;
import com.hackaton.todayfit.repository.ClothRepository;
import com.hackaton.todayfit.service.ClothService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final ClothCheckRepository clothCheckRepository;
    private final ClothService clothService;

    @GetMapping("/my-page")
    public String myPage(){
        return "myPage";
    }


}
