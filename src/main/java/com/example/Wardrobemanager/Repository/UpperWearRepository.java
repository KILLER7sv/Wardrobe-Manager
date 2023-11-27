package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.UpperWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpperWearRepository extends JpaRepository<UpperWear, Integer> {
}
