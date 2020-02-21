package com.example.form.services;

import com.example.form.dto.UserResponse;
import com.example.form.exchanges.GetFormFetchResponse;
import com.example.form.exchanges.GetUserEvaluationResponse;
import java.util.List;

public interface FormService {

  GetFormFetchResponse getFormData(String form_slug, boolean showAnswers);

  GetUserEvaluationResponse getUserEvaluation(String form_slug,List<UserResponse> userResponse);

}
