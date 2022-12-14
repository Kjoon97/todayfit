package com.hackaton.todayfit.controller;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.dto.OpenWeather;
import com.hackaton.todayfit.dto.RecommendClothDTO;
import com.hackaton.todayfit.dto.RegionCode;
import com.hackaton.todayfit.service.TodayClothService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodayClothController {

    private final TodayClothService todayClothService;

    @GetMapping("/")
    public String home(){
        return "redirect:/today-clothes";
    }

    @GetMapping("/today-clothes")
    public String todayClothes(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
        Float temperature = todayClothService.getWeatherInfo(principal);  //기온 정보
        String region = todayClothService.getRegionInfo(principal);      //지역 정보
        model.addAttribute("region",region);
        model.addAttribute("temp",temperature);

        //추천 옷 리스트
        ArrayList<List<RecommendClothDTO>> recommendCloth = todayClothService.getRecommendCloth(temperature, principal);
        System.out.println("recommendCloth = " + recommendCloth);

        model.addAttribute("tops", recommendCloth.get(0));   //상의
        model.addAttribute("pants",recommendCloth.get(1));   //하의
        return "todayCloth";
    }
}