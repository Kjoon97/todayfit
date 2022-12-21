package com.hackaton.todayfit.repository;

import com.hackaton.todayfit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String username);

    @Query(value = "SELECT COUNT(*) FROM User where email=:email", nativeQuery = true)
    int emailCheck(@Param("email") String email);
}
