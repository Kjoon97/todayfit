package com.hackaton.todayfit.repository;

import com.hackaton.todayfit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String username);
}
