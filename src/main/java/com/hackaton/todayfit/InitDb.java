package com.hackaton.todayfit;

import com.hackaton.todayfit.model.Cloth;
import com.hackaton.todayfit.repository.ClothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final ClothRepository clothRepository;

        public void dbInit(){
            clothRepository.deleteAll();

            Cloth cloth1 = createCloth("sleeveless", 28, 100, "", "상의");
            Cloth cloth2 = createCloth("short-sleeve", 28, 100, "", "상의");
            Cloth cloth3 = createCloth("linen", 28, 100, "", "상의");
            Cloth cloth4 = createCloth("thin-shirt", 23, 27.9, "", "상의");
            Cloth cloth5 = createCloth("blouse", 23, 27.9, "", "상의");
            Cloth cloth6 = createCloth("long-sleeve", 20, 22.9, "", "상의");
            Cloth cloth7 = createCloth("thin-cardigan", 17, 19.9, "", "상의");
            Cloth cloth8 = createCloth("neat", 17, 19.9, "", "상의");
            Cloth cloth9 = createCloth("mantoman", 17, 19.9, "", "상의");
            Cloth cloth10 = createCloth("hood", 17, 19.9, "", "상의");
            Cloth cloth11 = createCloth("jacket", 12, 16.9, "", "상의");
            Cloth cloth12 = createCloth("denim-jacket", 12, 16.9, "", "상의");
            Cloth cloth13 = createCloth("trench-coat", 9, 11.9, "", "상의");
            Cloth cloth14 = createCloth("night-jacket", 9, 11.9, "", "상의");
            Cloth cloth15 = createCloth("jumper", 9, 11.9, "", "상의");
            Cloth cloth16 = createCloth("strand-coat", 5, 8.9, "", "상의");
            Cloth cloth17 = createCloth("inner-wear", 5, 8.9, "", "상의");
            Cloth cloth18 = createCloth("leather-jacket", 5, 8.9, "", "상의");
            Cloth cloth19 = createCloth("padding", -100, 4.9, "", "상의");
            Cloth cloth20 = createCloth("thick-coat", -100, 4.9, "", "상의");
            Cloth cloth21 = createCloth("quilted-clothes", -100, 4.9, "", "상의");
            Cloth cloth22 = createCloth("scarf", -100, 4.9, "", "상의");
            Cloth cloth23 = createCloth("shorts", 28, 100, "", "하의");
            Cloth cloth24 = createCloth("miniskirt", 28, 100, "", "하의");
            Cloth cloth25 = createCloth("cotton-pants", 23, 27.9, "", "하의");
            Cloth cloth26 = createCloth("slacks", 20, 22.9, "", "하의");
            Cloth cloth27 = createCloth("long-pants", 17, 19.9, "", "하의");
            Cloth cloth28 = createCloth("stockings", 12, 16.9, "", "하의");
            Cloth cloth29 = createCloth("jeans", 12, 16.9, "", "하의");
            Cloth cloth30 = createCloth("napping-pants", -100, 11.9, "", "하의");

            List<Cloth> cloths = Arrays.asList(cloth1, cloth2, cloth3, cloth4, cloth5, cloth6, cloth7, cloth8, cloth9, cloth10, cloth11, cloth12, cloth13, cloth14,
                    cloth15, cloth16, cloth17, cloth18, cloth19, cloth20, cloth21, cloth22, cloth23, cloth24, cloth25, cloth26, cloth27, cloth28, cloth29, cloth30);

            clothRepository.saveAll(cloths);
        }

        private Cloth createCloth(String category, double lowestTemperature, double highTemperature, String imgUrl, String type) {
            Cloth cloth = new Cloth();
            cloth.setCloth(category,lowestTemperature,highTemperature,imgUrl,type);
            return cloth;
        }

    }
}
