package com.example.form.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Questions {

  private int qid;
  private int type;
  private String title;
  private String desc;
  private List<String> options = new ArrayList<>();
  private String answer;
}
