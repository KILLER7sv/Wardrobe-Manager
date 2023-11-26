package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.Bottom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BottomRepository extends JpaRepository<Bottom, Long> {
}