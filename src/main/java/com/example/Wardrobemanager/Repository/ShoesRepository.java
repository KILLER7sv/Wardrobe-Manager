package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.Shoes;
import com.example.Wardrobemanager.Model.UpperWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes , Integer> {
    @Query(value = "SELECT * FROM shoes WHERE color = :color", nativeQuery = true)
    List<Shoes> getShoesByColor(@Param("color") String color);

    @Query(value = "SELECT * FROM shoes WHERE genre = :genre",nativeQuery = true)
    List<Shoes> getShoesByGenre(@Param(("genre")) String genre);
}
