package com.servicenow.app.respository;

import com.servicenow.app.entity.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository  extends JpaRepository<TestTable, Long> {
  //save(), findOne(), findAll(), count(), delete()
  //public TestTable findById(Long Id);

//  @Query("SELECT u FROM User u WHERE u.status = 1")
//  Collection<User> findAllActiveUsers();

  @Query("SELECT u FROM TestTable u WHERE u.id = ?1")
  TestTable findTestsById(Long id);
}
