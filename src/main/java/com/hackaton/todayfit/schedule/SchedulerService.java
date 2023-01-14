package com.hackaton.todayfit.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchedulerService {

    private final WeatherApiService weatherApiService;

    //날씨 API 호출 스케줄러 (매일 6시간 간격으로 호출)
    @Scheduled(cron = "0 0 0/6 * * *")
    public void updateTemp(){
        weatherApiService.getWeatherInfo();
    }
}
