package com.example.form.repositories;

import com.example.form.dto.Forms;
import com.example.form.models.FormsEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormRepository extends MongoRepository<FormsEntity, String> {
  Forms findByName(String formName);
}