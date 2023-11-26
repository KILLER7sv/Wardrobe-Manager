package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes , Integer> {
}
