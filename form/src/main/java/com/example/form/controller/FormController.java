package com.example.form.controller;

import com.example.form.exchanges.GetFormFetchRequest;
import com.example.form.exchanges.GetFormFetchResponse;
import com.example.form.repositories.FormRepository;
import com.example.form.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FormController.FORM_API_ENDPOINT)
public class FormController {

  public static final String FORM_API_ENDPOINT = "/api/v1";
  public static final String FORM_API = "/form";

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
      GetFormFetchRequest getFormFetchRequest) {

    GetFormFetchResponse getFormFetchResponse =
        formService.findFormBySlug(getFormFetchRequest);

    return ResponseEntity.ok().body(getFormFetchResponse);
  }
}
