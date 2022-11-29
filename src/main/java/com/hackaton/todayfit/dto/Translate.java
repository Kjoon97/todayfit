package com.hackaton.todayfit.dto;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Component
public class Translate {

    public HashMap<String,String> translate(){
        LinkedHashMap<String, String> clothMap = new LinkedHashMap<>();
        clothMap.put("sleeveless","민소매");
        clothMap.put("short-sleeve","반팔");
        clothMap.put("linen","린넨 옷");
        clothMap.put("thin-shirt","얇은 셔츠");
        return clothMap;
    }
}
