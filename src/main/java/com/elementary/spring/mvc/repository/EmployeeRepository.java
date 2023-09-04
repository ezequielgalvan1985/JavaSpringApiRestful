package com.elementary.spring.mvc.repository;

import com.elementary.spring.mvc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}