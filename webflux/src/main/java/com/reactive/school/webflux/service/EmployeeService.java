package com.reactive.school.webflux.service;

import com.reactive.school.webflux.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Flux<Employee> getAllEmployees();
    Mono<Employee> addEmployee(Employee employee);
    Mono<Employee> updateEmployee(Employee employee, String employeeId);
}
