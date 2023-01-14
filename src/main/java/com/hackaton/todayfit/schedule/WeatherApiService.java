package com.hackaton.todayfit.schedule;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.dto.OpenWeather;
import com.hackaton.todayfit.model.User;
import com.hackaton.todayfit.model.Weather;
import com.hackaton.todayfit.repository.UserRepository;
import com.hackaton.todayfit.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherApiService {

    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final WeatherRepository weatherRepository;
    @Value("${openWeatherMap-api-key}")
    private String apiKey; // 발급받은 API key - properties 파일에 저장.

    @Transactional
    public void getWeatherInfo(){
        log.info("날씨 API에서 데이터 가져옵니다.");
        String [] regions = {"Seoul","Suwon","Chuncheon","Cheongju","Incheon","Jeonju","Daegu","Daejeon","Gwangju","Ulsan","Sejong","Busan","Jeju"};

        for (String region : regions) {
            StringBuilder urlBuilder = new StringBuilder(BASE_URL);
            try {
                urlBuilder.append("?" + URLEncoder.encode("q", "UTF-8") + "="+region);
                urlBuilder.append("&" + URLEncoder.encode("appid", "UTF-8") + "=" + apiKey);
                urlBuilder.append("&" + URLEncoder.encode("lang", "UTF-8") + "=kr");
                urlBuilder.append("&" + URLEncoder.encode("units", "UTF-8") + "=metric");
                RestTemplate restTemplate = new RestTemplate();
                OpenWeather response = restTemplate.getForObject(urlBuilder.toString(), OpenWeather.class);

                System.out.println("response = " + response.getMain().getTemp());
                System.out.println("region="+region);


                try {
                    //DB에 날씨 정보가 있으면 조회 후 변경 -> 변경 감지 -> 트랜잭션 끝나고 커밋 시점에 새로운 날씨 데이터로 DB 자동 변경
                    Weather weather = weatherRepository.findByRegion(region);
                    weather.setRegionAndTemp(region,response.getMain().getTemp());
                }catch(Exception e){
                    //초기에 DB에 날씨 정보가 없을 경우 예외 발생 -> 엔티티 새로 생성해서 날씨 DB에 저장
                    Weather weather = new Weather();
                    weather.setRegionAndTemp(region,response.getMain().getTemp());
                    weatherRepository.save(weather);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
