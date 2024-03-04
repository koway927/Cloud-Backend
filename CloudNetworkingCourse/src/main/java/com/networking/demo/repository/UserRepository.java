package com.networking.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.networking.demo.Model.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
