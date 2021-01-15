package com.servicenow.app.service.impl;

import com.servicenow.app.DTO.TestDTO;
import com.servicenow.app.entity.TestTable;
import com.servicenow.app.respository.TestRepository;
import com.servicenow.app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TetsServiceImpl implements TestService {
  @Autowired
  private TestRepository testRepository;

  @Override
  public List<TestTable> getAllTests() {
    return this.testRepository.findAll();
  }

  public TestTable findById(Long id){
    return  this.testRepository.findTestsById(id);
  }


  @Override
  public TestTable createTest(TestDTO testDTO) {
     TestTable testTable = new TestTable();
     testTable.setContent(testDTO.getContent());
     testTable.setTitle(testDTO.getTitle());
     return testRepository.save(testTable);
  }


}
