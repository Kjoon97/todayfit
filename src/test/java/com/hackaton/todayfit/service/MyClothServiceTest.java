package com.hackaton.todayfit.service;

import com.hackaton.todayfit.model.User;
import com.hackaton.todayfit.repository.ClothCheckRepository;
import com.hackaton.todayfit.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClothServiceTest {

    @Autowired
    private ClothCheckRepository clothCheckRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1(){
        User user = userRepository.findByEmail("kang");
        System.out.println("user = " + user.getEmail());
        int id = user.getId();
        List<String> categoryByUserId = clothCheckRepository.findCategories(id);
        System.out.println("categoryByUserId = " + categoryByUserId);
    }

}