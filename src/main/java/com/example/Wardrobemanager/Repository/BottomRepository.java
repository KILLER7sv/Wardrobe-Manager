package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Enum.Color;
import com.example.Wardrobemanager.Enum.Genre;
import com.example.Wardrobemanager.Model.Bottom;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BottomRepository extends JpaRepository<Bottom, Long> {
        @Query(value = "select * from Bottom where color = :color",nativeQuery = true)  // after colon variable name
        List<Bottom> getColor(String color);

    @Query(value = "select * from Bottom where genre = :genre",nativeQuery = true)
    List<Bottom> getGenre(String genre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Bottom b WHERE b.color = :color")
    int deleteByColor(@Param("color") Color color);

    @Modifying
    @Transactional
    @Query("DELETE FROM Bottom b WHERE b.genre = :genre")
    int deleteByGenre(@Param("genre") Genre genre);
}