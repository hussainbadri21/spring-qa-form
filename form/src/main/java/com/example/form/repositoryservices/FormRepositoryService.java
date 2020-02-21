package com.example.form.repositoryservices;

import com.example.form.dto.Questions;
import com.example.form.dto.UserResponse;
import com.example.form.dto.UserSession;
import java.util.List;

public interface FormRepositoryService {
  /**
   * Get the list of questions in a form
   * @param formName slug of the form
   * @return
   */
  List<Questions> getFormData(String formName,Boolean showAnswers);

   UserSession getUserEvaluation(String formName, List<UserResponse> userResponse);
}
