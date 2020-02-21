package com.example.form.repositoryservices;

import com.example.form.dto.Forms;
import com.example.form.dto.Questions;
import com.example.form.repositories.FormRepository;
import com.example.form.repositories.QuestionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FormRepositoryServiceImpl implements FormRepositoryService {

  @Autowired
  private FormRepository formRepository;

  @Autowired
  private QuestionRepository questionRepository;

  @Override
  public List<Questions> getFormData(String formName) {
    Forms form_data = formRepository.findByName(formName);
    return questionRepository.findByQidIn(form_data.getQuestions());
  }
}
