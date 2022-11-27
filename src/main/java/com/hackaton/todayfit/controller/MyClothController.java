package com.hackaton.todayfit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyClothController {

    @GetMapping("/my-clothes")
    public String myClothes(){
        return "myCloth";
    }
}
