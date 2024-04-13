package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.Bottom;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@Repository
//public interface BottomRepository extends JpaRepository<Bottom, Long> {
//        @Query(value = "select * from Bottom where color = :color",nativeQuery = true)  // after colon variable name
//        List<Bottom> getColor(String color);
//
//    @Query(value = "select * from Bottom where genre = :genre",nativeQuery = true)
//    List<Bottom> getGenre(String genre);
//
//    @Modifying
//    @Transactional
//    @Query(value = "DELETE FROM Bottom b WHERE b.color = :color")
//    int deleteByColor(@Param("color") Color color);
//
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Bottom b WHERE b.genre = :genre")
//    int deleteByGenre(@Param("genre") Genre genre);
//}

@Repository
public interface BottomRepository extends MongoRepository<Bottom, String> {
    List<Bottom> findByColor(String color);
    List<Bottom> findByGenre(String genre);
    int deleteByColor(String color);
    int deleteByGenre(String genre);
}