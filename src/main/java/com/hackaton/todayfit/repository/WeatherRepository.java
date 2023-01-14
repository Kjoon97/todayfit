package com.hackaton.todayfit.repository;

import com.hackaton.todayfit.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    Weather findByRegion(String region);

    @Query(value = "select temp from weather where region = ?", nativeQuery = true)
    float findTemp(String region);
}
