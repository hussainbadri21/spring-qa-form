package com.example.form.services;

import com.example.form.exchanges.GetFormFetchRequest;
import com.example.form.exchanges.GetFormFetchResponse;

public interface FormService {

  GetFormFetchResponse findFormBySlug(GetFormFetchRequest getRestaurantsRequest);
}
