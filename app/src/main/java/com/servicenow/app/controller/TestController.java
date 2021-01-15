package com.servicenow.app.controller;

import com.servicenow.app.DTO.TestDTO;
import com.servicenow.app.entity.TestTable;
import com.servicenow.app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private TestService testService;

  @GetMapping()
  public List<TestTable> getAlltest() {
    return testService.getAllTests();
  }

  @PostMapping()
  public TestTable createTest( @RequestBody TestDTO testDTO) {
    return testService.createTest(testDTO);
  }

  @GetMapping("{id}")
  public  TestTable getTest(@PathVariable(value = "id") Long testId){
    return this.testService.findById(testId);
  }


}
