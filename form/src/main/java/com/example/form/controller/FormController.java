package com.example.form.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FormController.FORM_API_ENDPOINT)
public class FormController {

  public static final String FORM_API_ENDPOINT = "/api/v1";
  public static final String FORM_API = "/question";

  @GetMapping("/")
  public ResponseEntity<String> getQuestions() {
    return ResponseEntity.ok().body("Hello World");
  }
}
