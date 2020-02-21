package com.example.form.controller;

import com.example.form.dto.UserResponse;
import com.example.form.exchanges.GetFormFetchResponse;
import com.example.form.exchanges.GetUserEvaluationResponse;
import com.example.form.repositories.FormRepository;
import com.example.form.services.FormService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FormController.FORM_API_ENDPOINT)
public class FormController {

  public static final String FORM_API_ENDPOINT = "/api/v1";
  public static final String FORM_API = "/questions/{form-slug}";

  @Autowired
  private FormService formService;

  @Autowired
  private FormRepository formRepository;

  @Autowired
  private MongoTemplate mt;

  @GetMapping("/")
  public ResponseEntity<String> getQuestions() {
    return ResponseEntity.ok().body("Hello World");
  }

  @GetMapping(FORM_API)
  public ResponseEntity<GetFormFetchResponse> getFormData(
      @PathVariable("form-slug") String form_slug) {

    GetFormFetchResponse getFormFetchResponse =
        formService.getFormData(form_slug,false);

    return ResponseEntity.ok().body(getFormFetchResponse);
  }

  @PostMapping(FORM_API)
  public ResponseEntity<GetUserEvaluationResponse> evaluateUserResponse(
      @PathVariable("form-slug") String form_slug,@RequestBody List<UserResponse> userResponses) {

    GetUserEvaluationResponse getUserEvaluationResponse =
        formService.getUserEvaluation(form_slug,userResponses);

    return ResponseEntity.ok().body(getUserEvaluationResponse);
  }

}
