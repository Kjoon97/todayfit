package com.hackaton.todayfit.repository;

import com.hackaton.todayfit.model.CheckCloth;
import com.hackaton.todayfit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ClothCheckRepository extends JpaRepository<CheckCloth, Integer> {

    @Query(value = "select category from checkcloth where user_id = ?", nativeQuery = true)
    List<String> findCategories(int userId);

    void deleteAllByUserId(int userId);
}
