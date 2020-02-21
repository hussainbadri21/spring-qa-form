package com.example.form.repositoryservices;

import com.example.form.dto.Forms;
import com.example.form.dto.Questions;
import com.example.form.dto.UserResponse;
import com.example.form.dto.UserSession;
import com.example.form.models.UserResponseEntity;
import com.example.form.repositories.FormRepository;
import com.example.form.repositories.QuestionRepository;
import com.example.form.repositories.UserResponseRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FormRepositoryServiceImpl implements FormRepositoryService {

  @Autowired
  private FormRepository formRepository;

  @Autowired
  private QuestionRepository questionRepository;

  @Autowired
  private UserResponseRepository userResponseRepository;


  @Override
  public List<Questions> getFormData(String formName, Boolean showAnswers) {
    Forms form_data = formRepository.findByName(formName);
    if (showAnswers) {
      return questionRepository.findByQidIn(form_data.getQuestions());
    }
    return questionRepository.findByQid(form_data.getQuestions());
  }

  public void saveUserResponse(List<UserResponse> userResponse) {
    UserResponseEntity userResponseEntity = new UserResponseEntity();
    BeanUtils.copyProperties(userResponse, userResponseEntity);
    userResponseRepository.save(userResponseEntity);
  }

  public boolean[] evaluateResponse(List<UserResponse> userResponse, List<Questions> questions) {
    boolean[] isCorrect = new boolean[userResponse.size()];
    for (int i = 0; i < userResponse.size(); i++) {
      String answer = questions.get(i).getAnswer();
      String response = userResponse.get(i).getUser_answer();
      if (questions.get(i).getType() == 2) {
        answer = sanitizeResponse(answer);
        response = sanitizeResponse(response);
      }
      isCorrect[i] = answer.equals(response);
    }
    return isCorrect;
  }

  @Override
  public UserSession getUserEvaluation(String formName, List<UserResponse> userResponse) {
    UserSession session = new UserSession();
    List<Questions> questions = getFormData(formName, true);
    session.setQuestions(questions);
    session.setUser_answer(userResponse);
    session.setIsCorrect(evaluateResponse(userResponse, questions));

    return session;
  }

  public String sanitizeResponse(String s) {
    String ans[] = s.split(",");
    Arrays.sort(ans);
    s = String.join(",", ans);
    return s;
  }

}
