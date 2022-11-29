package com.hackaton.todayfit.controller;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.model.CheckCloth;
import com.hackaton.todayfit.model.Item;
import com.hackaton.todayfit.repository.ClothCheckRepository;
import com.hackaton.todayfit.service.ClothService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MyClothController {

    private final ClothService clothService;

    //상세보기
    @GetMapping("/my-clothes")
    public String myCloth(@ModelAttribute Item item,@AuthenticationPrincipal PrincipalDetails principal){
        List<String> categories = clothService.findCategory(principal);
        item.updateClothes(categories);
        return "myCloth";
    }

    //폼
    @GetMapping("/check")
    public String addForm(Model model, @AuthenticationPrincipal PrincipalDetails principal){
        List<String> categories = clothService.findCategory(principal);
        Item item = new Item();
        item.updateClothes(categories);
        model.addAttribute("item",item);
        return "addCloth";
    }

    //옷 등록.
    @PostMapping("/check")
    public String item(@ModelAttribute Item item, @AuthenticationPrincipal PrincipalDetails principal) {
        System.out.println("item = " + item.getClothes());
        clothService.checkCloth(item, principal);
        return "redirect:/my-clothes";
    }


}
