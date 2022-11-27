package com.hackaton.todayfit.controller;

import com.hackaton.todayfit.dto.OpenWeather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

@Controller
public class TodayClothController {

    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final String apiKey = "9bed50423a4dfdaa3ef1ba25fd9bc7e1"; // 발급받은 API key

    @GetMapping("/today-clothes")
    public String todayClothes(Model model) {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        try {
            urlBuilder.append("?" + URLEncoder.encode("q", "UTF-8") + "=seoul");
            urlBuilder.append("&" + URLEncoder.encode("appid", "UTF-8") + "=" + apiKey);
            urlBuilder.append("&" + URLEncoder.encode("lang", "UTF-8") + "=kr");
            urlBuilder.append("&" + URLEncoder.encode("units", "UTF-8") + "=metric");
            RestTemplate restTemplate = new RestTemplate();
            OpenWeather response = restTemplate.getForObject(urlBuilder.toString(), OpenWeather.class);
            System.out.println("response = " + response.getMain().getTemp());
            System.out.println(response);
            model.addAttribute("temp",response.getMain().getTemp());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "todayCloth";
    }
}