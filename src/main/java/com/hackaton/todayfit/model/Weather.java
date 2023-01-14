package com.hackaton.todayfit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //지역
    private String region;

    //기온
    private float temp;

    public void setRegionAndTemp(String region, float temp){
        this.region = region;
        this.temp = temp;
    }

}
