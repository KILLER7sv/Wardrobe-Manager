package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.Bottom;
import com.example.Wardrobemanager.Model.UpperWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpperWearRepository extends JpaRepository<UpperWear, Integer> {
    @Query(value = "SELECT * FROM upper_wear WHERE color = :color", nativeQuery = true)
    List<UpperWear> getTopsByColor(@Param("color") String color);

    @Query(value = "SELECT * FROM upper_wear WHERE genre = :genre",nativeQuery = true)
    List<UpperWear> getTopsByGenre(@Param(("genre")) String genre);
}
