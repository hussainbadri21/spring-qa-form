package com.example.form.repositories;

import com.example.form.dto.UserResponse;
import com.example.form.models.UserResponseEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserResponseRepository extends MongoRepository<UserResponseEntity, String> {

}
