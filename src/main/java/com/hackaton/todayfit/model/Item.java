package com.hackaton.todayfit.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
public class Item {

    private Long id;
    private List<String> clothes;

    public void updateClothes(List<String> clothes){
        this.clothes = clothes;
    }
}
