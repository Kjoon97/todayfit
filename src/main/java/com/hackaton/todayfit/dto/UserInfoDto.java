package com.hackaton.todayfit.dto;

import com.hackaton.todayfit.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoDto {

    private int id;
    private String email;
    private String password;
    private String nickname;
    private String region;

    public UserInfoDto(int id, String email, String password, String nickname, String region) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.region = region;
    }
}
