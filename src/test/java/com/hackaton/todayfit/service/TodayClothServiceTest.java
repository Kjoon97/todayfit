package com.hackaton.todayfit.service;

import com.hackaton.todayfit.dto.RecommendClothDTO;
import com.hackaton.todayfit.dto.Translate;
import com.hackaton.todayfit.model.Cloth;
import com.hackaton.todayfit.repository.ClothCheckRepository;
import com.hackaton.todayfit.repository.ClothRepository;
import com.hackaton.todayfit.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TodayClothServiceTest {

    @Autowired
    private ClothRepository clothRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClothCheckRepository clothCheckRepository;

    @Autowired
    private Translate translate;

    @Test
    public void getRecommendCloth(){
        ArrayList<RecommendClothDTO> recommendTopClothes = new ArrayList<>();
        ArrayList<RecommendClothDTO> recommendPantsClothes = new ArrayList<>();

        //체크한 카테고리들.
        List<String> checkedClothes = clothCheckRepository.findCategories(1);

        //기온에 맞는 옷들.
        List<Cloth> recommendClothes = clothRepository.findRecommendClothes((float)9.7);
        for (Cloth recommendCloth : recommendClothes) {
            if(checkedClothes.contains(recommendCloth.getCategory())){
                if(recommendCloth.getType().equals("상의")){
                    String category = translate.translate().get(recommendCloth.getCategory());
                    String imgUrl = recommendCloth.getImgUrl();
                    RecommendClothDTO recommendClothDTO = new RecommendClothDTO(category,imgUrl);
                    recommendTopClothes.add(recommendClothDTO);
                }else{
                    String category = translate.translate().get(recommendCloth.getCategory());
                    String imgUrl = recommendCloth.getImgUrl();
                    RecommendClothDTO recommendClothDTO = new RecommendClothDTO(category,imgUrl);
                    recommendPantsClothes.add(recommendClothDTO);
                }
            }
        }
        System.out.println("recommendPantsClothes = " + recommendPantsClothes);
        System.out.println("recommendTopClothes = " + recommendTopClothes);
        ArrayList<List<RecommendClothDTO>> recommend = new ArrayList<>();
        recommend.add(recommendTopClothes);
        recommend.add(recommendPantsClothes);
        System.out.println("recommend = " + recommend);
    }

}