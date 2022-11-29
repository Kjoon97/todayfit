package com.hackaton.todayfit.service;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.dto.Translate;
import com.hackaton.todayfit.model.CheckCloth;
import com.hackaton.todayfit.model.Cloth;
import com.hackaton.todayfit.model.Item;
import com.hackaton.todayfit.model.User;
import com.hackaton.todayfit.repository.ClothCheckRepository;
import com.hackaton.todayfit.repository.ClothRepository;
import com.hackaton.todayfit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothService {

    private final ClothCheckRepository clothCheckRepository;
    private final Translate translate;
    private final UserRepository userRepository;

    //체크
    @Transactional
    public void checkCloth(Item item, PrincipalDetails principal){
        clothCheckRepository.deleteAll();
        List<String> clothes = item.getClothes();
        User user = userRepository.findByEmail(principal.getUsername());
        for (String cloth : clothes) {
            CheckCloth checkCloth = new CheckCloth();
            checkCloth.setClothAndUser(cloth,user);
            clothCheckRepository.save(checkCloth);
        }
    }

    //체크한 옷 종류 조회하기
    @Transactional
    public List<String> findCategory(PrincipalDetails principalDetails){
        User user = userRepository.findByEmail(principalDetails.getUsername());
        List<String> checkedClothes = clothCheckRepository.findCategories(user.getId());
        return checkedClothes;
    }
}
