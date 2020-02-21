package com.example.form.exchanges;

import com.example.form.dto.Forms;
import com.example.form.dto.Questions;
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
public class GetFormFetchResponse {
  List<Questions> questions;
}
