package com.example.form.repositories;

import com.example.form.dto.Questions;
import com.example.form.models.QuestionsEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface QuestionRepository extends MongoRepository<QuestionsEntity, String> {

  @Query(value = "{qid:{$in:?0}}",fields = "{'answer':0}")
  List<Questions> findByQid(List<Integer> question_ids);

  List<Questions> findByQidIn(List<Integer> question_ids);
}