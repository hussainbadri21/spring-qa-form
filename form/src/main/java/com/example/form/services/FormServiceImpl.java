package com.example.form.services;

import com.example.form.exchanges.GetFormFetchRequest;
import com.example.form.exchanges.GetFormFetchResponse;
import com.example.form.repositoryservices.FormRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FormServiceImpl implements FormService {

  @Autowired
  private FormRepositoryServiceImpl formRepositoryServiceImpl;

  @Override
  public GetFormFetchResponse findFormBySlug(GetFormFetchRequest getFormFetchRequest) {
    GetFormFetchResponse resp = new GetFormFetchResponse();
    resp.setQuestions(formRepositoryServiceImpl.getFormData(getFormFetchRequest.getFormName()));
    return resp;
  }
}
