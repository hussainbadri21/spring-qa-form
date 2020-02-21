package com.example.form.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSession {

  private List<Questions> questions = new ArrayList<>();
  private List<UserResponse> user_answer = new ArrayList<>();
  private boolean isCorrect[];

}
