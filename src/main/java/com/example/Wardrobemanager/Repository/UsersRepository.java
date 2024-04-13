package com.example.Wardrobemanager.Repository;

import com.example.Wardrobemanager.Model.UpperWear;
import com.example.Wardrobemanager.Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Users findByUsername(String username);
}
