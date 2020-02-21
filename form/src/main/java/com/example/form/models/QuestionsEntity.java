package com.example.form.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questions")
@NoArgsConstructor
public class QuestionsEntity {
  @NotNull
  private int qid;

  @NotNull
  private int type;

  @NotNull
  private String title;

  @NotNull
  private String desc;


  private List<String> options = new ArrayList<>();

  @NotNull
  private String answer;
}
