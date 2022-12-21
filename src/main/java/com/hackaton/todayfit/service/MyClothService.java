package com.hackaton.todayfit.service;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.dto.Translate;
import com.hackaton.todayfit.model.CheckCloth;
import com.hackaton.todayfit.dto.Item;
import com.hackaton.todayfit.model.User;
import com.hackaton.todayfit.repository.ClothCheckRepository;
import com.hackaton.todayfit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyClothService {

    private final ClothCheckRepository clothCheckRepository;
    private final Translate translate;
    private final UserRepository userRepository;

    //체크
    @Transactional
    public void checkCloth(Item item, PrincipalDetails principal){
        User user = userRepository.findByEmail(principal.getUsername());
        clothCheckRepository.deleteAllByUserId(user.getId());    //체크 저장소에 이전 체크 이력이 누적이 되기 때문에 모두 삭제.
        List<String> clothes = item.getClothes();
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
