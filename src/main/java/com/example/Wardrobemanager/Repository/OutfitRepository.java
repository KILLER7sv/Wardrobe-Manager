package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutfitRepository extends JpaRepository<Outfit, Integer> {
}
