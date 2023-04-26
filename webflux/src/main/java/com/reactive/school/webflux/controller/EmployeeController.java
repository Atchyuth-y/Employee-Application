package com.reactive.school.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.school.webflux.entity.Employee;
import com.reactive.school.webflux.service.EmployeeServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class EmployeeController {
  
  @Autowired
  private EmployeeServiceImpl employeeService;

  @PostMapping("/add")
  public Mono<Employee> createEmployee(@RequestBody Employee employee){
    return employeeService.addEmployee(employee);
  }

  @PutMapping("/update/{studentId}")
  public Mono<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId")String employeeId){
    return employeeService.updateEmployee(employee, employeeId);
  }

  @GetMapping("/all")
  public Flux<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
  }
}
