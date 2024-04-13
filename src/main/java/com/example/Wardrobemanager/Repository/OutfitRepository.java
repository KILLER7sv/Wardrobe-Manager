package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.Outfit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutfitRepository extends MongoRepository<Outfit, Integer> {
}
