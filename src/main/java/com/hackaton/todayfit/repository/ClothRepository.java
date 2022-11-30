package com.hackaton.todayfit.repository;

import com.hackaton.todayfit.model.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothRepository extends JpaRepository<Cloth, Integer> {

    @Query(value = "select * from cloth where lowestTemperature<= :temp1 and highTemperature>=:temp1", nativeQuery = true)
    List<Cloth> findRecommendClothes(@Param("temp1") float temp1);

}
