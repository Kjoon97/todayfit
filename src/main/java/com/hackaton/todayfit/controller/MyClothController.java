package com.hackaton.todayfit.controller;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.dto.Item;
import com.hackaton.todayfit.service.MyClothService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyClothController {

    private final MyClothService myClothService;

    //나의 옷 조회
    @GetMapping("/my-clothes")
    public String myCloth(@ModelAttribute Item item,@AuthenticationPrincipal PrincipalDetails principal){
        List<String> categories = myClothService.findCategory(principal);
        item.setterClothes(categories);
        return "myCloth";
    }

    //폼
    @GetMapping("/check")
    public String addForm(Model model, @AuthenticationPrincipal PrincipalDetails principal){
        List<String> categories = myClothService.findCategory(principal);
        Item item = new Item();
        item.setterClothes(categories);
        model.addAttribute("item",item);
        return "addCloth";
    }

    //옷 등록.
    @PostMapping("/check")
    public String item(@ModelAttribute Item item, @AuthenticationPrincipal PrincipalDetails principal) {
        System.out.println("item = " + item.getClothes());
        myClothService.checkCloth(item, principal);
        return "redirect:/my-clothes";
    }


}
