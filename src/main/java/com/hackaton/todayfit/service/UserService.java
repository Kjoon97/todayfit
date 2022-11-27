package com.hackaton.todayfit.service;

import com.hackaton.todayfit.model.RoleType;
import com.hackaton.todayfit.model.User;
import com.hackaton.todayfit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    //회원가입.
    @Transactional
    public void register(User user) {
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);       //비밀번호 해쉬 인코딩.
        user.setRoleAndEncPassword(RoleType.USER, encPassword);
        userRepository.save(user);
    }

}
