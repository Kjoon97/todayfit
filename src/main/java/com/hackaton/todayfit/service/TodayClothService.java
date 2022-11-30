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

    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final String apiKey = "9bed50423a4dfdaa3ef1ba25fd9bc7e1"; // 발급받은 API key
    private final ClothCheckRepository clothCheckRepository;
    private final UserRepository userRepository;
    private final ClothRepository clothRepository;
    private final Translate translate;

    public Float getWeatherInfo(){
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        try {
            urlBuilder.append("?" + URLEncoder.encode("q", "UTF-8") + "=seoul");
            urlBuilder.append("&" + URLEncoder.encode("appid", "UTF-8") + "=" + apiKey);
            urlBuilder.append("&" + URLEncoder.encode("lang", "UTF-8") + "=kr");
            urlBuilder.append("&" + URLEncoder.encode("units", "UTF-8") + "=metric");
            RestTemplate restTemplate = new RestTemplate();
            OpenWeather response = restTemplate.getForObject(urlBuilder.toString(), OpenWeather.class);
            System.out.println("response = " + response.getMain().getTemp());
            System.out.println(response);

            return response.getMain().getTemp();

        } catch (Exception e) {
            e.printStackTrace();
            return -1000000000F;
        }
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
