package com.example.form.services;

import com.example.form.dto.UserResponse;
import com.example.form.exchanges.GetFormFetchResponse;
import com.example.form.exchanges.GetUserEvaluationResponse;
import com.example.form.repositoryservices.FormRepositoryServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FormServiceImpl implements FormService {

  @Autowired
  private FormRepositoryServiceImpl formRepositoryServiceImpl;

  @Override
  public GetFormFetchResponse getFormData(String form_slug, boolean showAnswers) {
    GetFormFetchResponse resp = new GetFormFetchResponse();
    resp.setQuestions(formRepositoryServiceImpl.getFormData(form_slug, showAnswers));
    return resp;
  }

  @Override
  public GetUserEvaluationResponse getUserEvaluation(String form_slug,
      List<UserResponse> userResponse) {
    GetUserEvaluationResponse resp = new GetUserEvaluationResponse();
    resp.setUserSession(formRepositoryServiceImpl.getUserEvaluation(form_slug, userResponse));
    return resp;
  }
}
