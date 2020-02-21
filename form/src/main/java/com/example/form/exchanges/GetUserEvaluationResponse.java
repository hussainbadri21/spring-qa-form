package com.example.form.exchanges;

import com.example.form.dto.Questions;
import com.example.form.dto.UserSession;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetUserEvaluationResponse {
  UserSession userSession;
}
