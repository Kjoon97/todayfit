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

            Cloth cloth1 = createCloth("sleeveless", 28, 100, "https://shop2.daumcdn.net/thumb/R500x500/?fname=http%3A%2F%2Fshop2.daumcdn.net%2Fshophow%2Fp%2FA5116003485.jpg%3Fut%3D20220928150843", "상의");
            Cloth cloth2 = createCloth("short-sleeve", 28, 100, "https://image.msscdn.net/images/goods_img/20180619/803523/803523_1_500.jpg", "상의");
            Cloth cloth3 = createCloth("linen", 28, 100, "https://img.29cm.co.kr/next-product/2022/03/28/4e4b59640ea14cedad77493b2e7b773e_20220328134722.png?width=700", "상의");
            Cloth cloth4 = createCloth("thin-shirt", 23, (float) 27.9, "https://m.ilsanghabo.com/web/product/big/202206/60b646cc6ff460cff66a89c9c9757400.jpg", "상의");
            Cloth cloth5 = createCloth("blouse", 23, (float) 27.9, "https://simage-kr.uniqlo.com/goods/31/13/70/02/436192_COL_COL01_1000.jpg", "상의");
            Cloth cloth6 = createCloth("long-sleeve", 20, (float) 22.9, "http://okstar.kr/web/product/tiny/202108/b43091bb16fb943fa90d17db8be42e78.jpg", "상의");
            Cloth cloth7 = createCloth("thin-cardigan", 17, (float) 19.9, "https://sitem.ssgcdn.com/64/41/07/item/1000045074164_i1_1200.jpg", "상의");
            Cloth cloth8 = createCloth("neat", 17, (float) 19.9, "https://www.leekorea.co.kr/web/product/big/202210/023530755fe830780c6e51f481145837.jpg", "상의");
            Cloth cloth9 = createCloth("mantoman", 17, (float) 19.9, "https://image.msscdn.net/images/goods_img/20190923/1163604/1163604_2_500.jpg", "상의");
            Cloth cloth10 = createCloth("hood", 17, (float) 19.9, "https://image.msscdn.net/images/goods_img/20210910/2122596/2122596_2_500.jpg", "상의");
            Cloth cloth11 = createCloth("jacket", 12, (float) 16.9, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtqkhFZidSxTMeMJagNjwjzeAQoefWsRnZe2MU-6q3Lk7uzsqOWoPvy8CopQDCflmmXWA&usqp=CAU", "상의");
            Cloth cloth12 = createCloth("denim-jacket", 12, (float) 16.9, "https://image.msscdn.net/images/goods_img/20160811/394428/394428_1_500.jpg", "상의");
            Cloth cloth13 = createCloth("trench-coat", 9, (float) 11.9, "https://image.thehyundai.com/static/4/8/4/56/A1/hnm40A1564848_4364_848.jpg", "상의");
            Cloth cloth14 = createCloth("night-jacket", 9, (float) 11.9, "https://seuongyhon.hgodo.com/main/woman/WW1654.jpg", "상의");
            Cloth cloth15 = createCloth("jumper", 9, (float) 11.9, "https://image.msscdn.net/images/goods_img/20190228/968409/968409_3_500.jpg", "상의");
            Cloth cloth16 = createCloth("strand-coat", 5, (float) 8.9, "https://contents.lotteon.com/itemimage/_v222826/LO/19/63/73/48/43/_1/96/37/34/84/4/LO1963734843_1963734844_1.jpg/dims/optimize/dims/resizemc/400x400", "상의");
            Cloth cloth17 = createCloth("inner-wear", 5, (float) 8.9, "http://img.danawa.com/prod_img/500000/325/117/img/13117325_1.jpg?_v=20210112112820", "상의");
            Cloth cloth18 = createCloth("leather-jacket", 5, (float) 8.9, "http://img4.tmon.kr/cdn3/deals/2019/12/20/2858472366/front_2211a_dukgd.jpg", "상의");
            Cloth cloth19 = createCloth("padding", -100, (float) 4.9, "https://image.msscdn.net/images/goods_img/20191002/1175159/1175159_1_500.jpg", "상의");
            Cloth cloth20 = createCloth("thick-coat", -100, (float) 4.9, "https://contents.lotteon.com/itemimage/LO/19/64/08/49/87/_1/96/40/84/98/8/LO1964084987_1964084988_1.jpg/dims/optimize/dims/resizemc/400x400", "상의");
            Cloth cloth21 = createCloth("quilted-clothes", -100, (float) 4.9, "https://img.alicdn.com/imgextra/i2/136039152/O1CN0188fzrp2HTfLx9mLRF_!!136039152.jpg", "상의");
            Cloth cloth22 = createCloth("scarf", -100, (float) 4.9, "http://recipeofgirl.com/web/product/big/202008/3a781713d5d34bd618bc924e014c4b6c.jpg", "상의");
            Cloth cloth23 = createCloth("shorts", 28, 100, "https://m.wiisnt.co.kr/web/product/medium/202204/c774d13ec4c7f7bbcab4fabf6ca56f48.jpg", "하의");
            Cloth cloth24 = createCloth("miniskirt", 28, 100, "https://cafe24img.poxo.com/spao/web/product/small/202211/59585b8d0b409591832fa2ad78b4e3be.jpg", "하의");
            Cloth cloth25 = createCloth("cotton-pants", 23, (float) 27.9, "https://image.msscdn.net/images/goods_img/20180328/744429/744429_1_500.jpg", "하의");
            Cloth cloth26 = createCloth("slacks", 20, (float) 22.9, "https://image.sivillage.com/upload/C00001/files/product/01/P0000/26/08/63/01P0000260863.jpg?RS=750&SP=1", "하의");
            Cloth cloth27 = createCloth("long-pants", 17, (float) 19.9, "https://www.elandrs.com/upload/prd/img/707/600/2009048707_0000001.jpg", "하의");
            Cloth cloth28 = createCloth("stockings", 12, (float) 16.9, "https://cdn-images.farfetch-contents.com/13/81/93/00/13819300_17446465_300.jpg", "하의");
            Cloth cloth29 = createCloth("jeans", 12, (float) 16.9, "http://jparkers.godohosting.com/upload/item/jean2022Bl_list_01.jpg", "하의");
            Cloth cloth30 = createCloth("napping-pants", -100, (float) 11.9, "https://img.danawa.com/prod_img/500000/371/795/img/12795371_1.jpg?shrink=330:330&_v=20201130145455", "하의");

            List<Cloth> cloths = Arrays.asList(cloth1, cloth2, cloth3, cloth4, cloth5, cloth6, cloth7, cloth8, cloth9, cloth10, cloth11, cloth12, cloth13, cloth14,
                    cloth15, cloth16, cloth17, cloth18, cloth19, cloth20, cloth21, cloth22, cloth23, cloth24, cloth25, cloth26, cloth27, cloth28, cloth29, cloth30);

            clothRepository.saveAll(cloths);
        }

        private Cloth createCloth(String category, float lowestTemperature, float highTemperature, String imgUrl, String type) {
            Cloth cloth = new Cloth();
            cloth.setCloth(category,lowestTemperature,highTemperature,imgUrl,type);
            return cloth;
        }

    }
}
