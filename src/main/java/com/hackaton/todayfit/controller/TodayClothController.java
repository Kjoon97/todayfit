package com.hackaton.todayfit.controller;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.dto.OpenWeather;
import com.hackaton.todayfit.service.TodayClothService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodayClothController {

    private final TodayClothService todayClothService;

    @GetMapping("/today-clothes")
    public String todayClothes(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
        Float temperature = todayClothService.getWeatherInfo();
        model.addAttribute("temp",temperature);
        ArrayList<List<String>> recommendCloth = todayClothService.getRecommendCloth(temperature, principal);
        System.out.println("recommendCloth = " + recommendCloth);
        model.addAttribute("tops", recommendCloth.get(0));
        model.addAttribute("pants",recommendCloth.get(1));
        return "todayCloth";
    }
}