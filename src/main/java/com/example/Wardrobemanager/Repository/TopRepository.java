package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.Top;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopRepository extends JpaRepository<Top, Integer> {
}
