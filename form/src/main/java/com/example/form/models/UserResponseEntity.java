package com.example.form.models;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user_sessions")
@NoArgsConstructor
public class UserResponseEntity {

  @NotNull
  private int qid;

  @NotNull
  private String user_answer;
}
