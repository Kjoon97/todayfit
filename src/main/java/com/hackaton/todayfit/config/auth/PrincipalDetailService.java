package com.hackaton.todayfit.config.auth;

import com.hackaton.todayfit.model.User;
import com.hackaton.todayfit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    //시큐리티가 로그인 시 email과 password 가로채서 password 비교, email이 있는지 db에서 확인.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return new PrincipalDetails(user);
    }
}
