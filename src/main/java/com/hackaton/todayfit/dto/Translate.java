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
        clothMap.put("blouse","블라우스");
        clothMap.put("long-sleeve","긴 팔");
        clothMap.put("thin-cardigan","얇은 가디건");
        clothMap.put("neat","니트");
        clothMap.put("mantoman","맨투맨");
        clothMap.put("hood","후드");
        clothMap.put("jacket","자켓");
        clothMap.put("denim-jacket","청 자켓");
        clothMap.put("trench-coat","트렌치 코트");
        clothMap.put("night-jacket","야상");
        clothMap.put("jumper","점퍼");
        clothMap.put("strand-coat","올 코트");
        clothMap.put("inner-wear","히트텍");
        clothMap.put("leather-jacket","가죽 자켓");
        clothMap.put("padding","패딩");
        clothMap.put("thick-coat","두꺼운 코트");
        clothMap.put("quilted-clothes","누빔 옷");
        clothMap.put("scarf","목도리");
        clothMap.put("shorts","반 바지");
        clothMap.put("miniskirt","짧은 치마");
        clothMap.put("cotton-pants","면 바지");
        clothMap.put("slacks","슬랙스");
        clothMap.put("long-pants","긴 바지");
        clothMap.put("stockings","스타킹");
        clothMap.put("jeans","청 바지");
        clothMap.put("napping-pants","기모 바지");

        return clothMap;
    }
}
