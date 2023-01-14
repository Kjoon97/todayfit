package com.hackaton.todayfit.service;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.dto.OpenWeather;
import com.hackaton.todayfit.dto.RecommendClothDTO;
import com.hackaton.todayfit.dto.Translate;
import com.hackaton.todayfit.model.CheckCloth;
import com.hackaton.todayfit.model.Cloth;
import com.hackaton.todayfit.model.User;
import com.hackaton.todayfit.repository.ClothCheckRepository;
import com.hackaton.todayfit.repository.ClothRepository;
import com.hackaton.todayfit.repository.UserRepository;
import com.hackaton.todayfit.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.ServerEndpoint;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodayClothService {

    private final ClothCheckRepository clothCheckRepository;
    private final UserRepository userRepository;
    private final ClothRepository clothRepository;
    private final WeatherRepository weatherRepository;
    private final Translate translate;

    public String getRegionInfo(PrincipalDetails principal){
        User user = userRepository.findByEmail(principal.getUsername());
        String region = user.getRegion();
        return region;
    }

    public Float getWeatherInfo(PrincipalDetails principal){
        User user = userRepository.findByEmail(principal.getUsername());
        String region = user.getRegion();
        float temp = weatherRepository.findTemp(region);
        return temp;
    }

    public ArrayList<List<RecommendClothDTO>> getRecommendCloth(float temp, PrincipalDetails principal){
        User user = userRepository.findByEmail(principal.getUsername());
        ArrayList<RecommendClothDTO> recommendTopClothes = new ArrayList<>();
        ArrayList<RecommendClothDTO> recommendPantsClothes = new ArrayList<>();

        //체크한 카테고리들.
        List<String> checkedClothes = clothCheckRepository.findCategories(user.getId());

        //기온에 맞는 옷들.
        List<Cloth> recommendClothes = clothRepository.findRecommendClothes(temp);
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
        return recommend;
    }

}
