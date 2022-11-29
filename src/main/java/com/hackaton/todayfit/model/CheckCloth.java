package com.hackaton.todayfit.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CheckCloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    public void setClothAndUser(String category, User user){
        this.category = category;
        this.user = user;
    }
}
