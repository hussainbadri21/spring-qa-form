package com.example.form.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "forms")
@NoArgsConstructor
public class FormsEntity {

  @NotNull
  private String name;

  @NotNull
  private List<Integer> questions = new ArrayList<>();

}