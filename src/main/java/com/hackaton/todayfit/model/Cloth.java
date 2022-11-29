package com.hackaton.todayfit.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String category;

    private float lowestTemperature;

    private float highTemperature;

    private String imgUrl;

    private String type;

    public void setCloth(String category, float lowestTemperature, float highTemperature, String imgUrl, String type){
        this.category =category;
        this.lowestTemperature = lowestTemperature;
        this.highTemperature = highTemperature;
        this.imgUrl = imgUrl;
        this.type =type;
    }

}
