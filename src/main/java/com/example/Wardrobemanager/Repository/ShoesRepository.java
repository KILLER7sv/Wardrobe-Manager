package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.Shoes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoesRepository extends MongoRepository<Shoes, String> {
    List<Shoes> findByColor(String color);

    List<Shoes> findByGenre(String genre);

    List<Shoes> findByUserId(String userId);
}
