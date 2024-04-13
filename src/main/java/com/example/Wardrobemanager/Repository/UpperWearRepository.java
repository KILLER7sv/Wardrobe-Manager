package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.UpperWear;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpperWearRepository extends MongoRepository<UpperWear, String> {
    List<UpperWear> findByColor(String color);
    List<UpperWear> findByGenre(String genre);
}
