package com.hackaton.todayfit.service;

import com.hackaton.todayfit.config.auth.PrincipalDetails;
import com.hackaton.todayfit.dto.UserInfoDto;
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

    //회원 조회
    public UserInfoDto findUser(PrincipalDetails principal){
        User userEntity = userRepository.findByEmail(principal.getUsername());
        UserInfoDto userInfoDto = new UserInfoDto(userEntity.getId(),userEntity.getEmail(), userEntity.getPassword(), userEntity.getNickname());
        return userInfoDto;
    }

    //회원 수정
    @Transactional
    public void userUpdate(UserInfoDto user){
        System.out.println("user = " + user.getId());
        System.out.println("user = " + user.getNickname());
        System.out.println("user = " + user.getEmail());
        System.out.println("user = " + user.getPassword());
        //영속성 컨텍스트 user 오브젝트를 영속화 시키고 영속화된 user 객체 수정-> 함수 종료 ->트랜잭션 끝(커밋) 후 자동으로 더티체킹.
        User persistenceUser = userRepository.findById(user.getId()).orElseThrow(()-> {
            return new IllegalArgumentException("회원 찾기 실패");
        });
        String rawPwd = user.getPassword();
        String encodePwd = encoder.encode(rawPwd);
        persistenceUser.setPwdAndNickname(encodePwd,user.getNickname());
    }

}
