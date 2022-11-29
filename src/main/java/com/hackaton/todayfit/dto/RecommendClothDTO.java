package com.hackaton.todayfit.dto;

import lombok.Data;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.Entity;
import java.util.ArrayList;

@Data
public class RecommendClothDTO {

    private String category;
    private String type;
}
