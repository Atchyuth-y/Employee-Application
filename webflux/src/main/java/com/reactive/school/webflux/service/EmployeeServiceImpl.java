package com.reactive.school.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.school.webflux.entity.Employee;
import com.reactive.school.webflux.repo.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService{
  
  @Autowired
  private EmployeeRepository employeeRepository;

  public Flux<Employee> getAllEmployees(){
    return employeeRepository.findAll();
  }

  public  Mono<Employee> addEmployee(Employee employee){
    return employeeRepository.save(employee);
  }

  public Mono<Employee> updateEmployee(Employee employee, String employeeId){
    return employeeRepository.findById(employeeId)
    .map(s -> {
      s.setEmployeeName(employee.getEmployeeName());
      s.setAddress(employee.getAddress());
      s.setDepartment(employee.getDepartment());
      return s;
    }).flatMap(s -> employeeRepository.save(s));
  }
}
