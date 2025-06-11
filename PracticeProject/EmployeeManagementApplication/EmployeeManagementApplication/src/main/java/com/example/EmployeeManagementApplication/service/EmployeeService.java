package com.example.EmployeeManagementApplication.service;

import com.example.EmployeeManagementApplication.dto.EmployeeResponseDTO;
import com.example.EmployeeManagementApplication.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO saveEmployee(Employee employee);

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    List<EmployeeResponseDTO> getAllEmployeesByName(String name);
}
