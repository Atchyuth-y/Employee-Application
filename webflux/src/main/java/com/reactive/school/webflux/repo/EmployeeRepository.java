package com.reactive.school.webflux.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.school.webflux.entity.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
  
}
