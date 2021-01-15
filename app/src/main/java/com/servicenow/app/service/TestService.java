package com.servicenow.app.service;

import com.servicenow.app.DTO.TestDTO;
import com.servicenow.app.entity.TestTable;

import java.util.List;

public interface TestService {

  public List<TestTable> getAllTests();

  public TestTable findById(Long id);

  public TestTable createTest(TestDTO testDTO);
}
