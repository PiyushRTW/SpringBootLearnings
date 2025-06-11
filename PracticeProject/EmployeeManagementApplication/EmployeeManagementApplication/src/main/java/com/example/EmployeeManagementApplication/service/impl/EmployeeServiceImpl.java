package com.example.EmployeeManagementApplication.service.impl;

import com.example.EmployeeManagementApplication.dto.EmployeeResponseDTO;
import com.example.EmployeeManagementApplication.entity.Employee;
import com.example.EmployeeManagementApplication.repository.EmployeeRepository;
import com.example.EmployeeManagementApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponseDTO> employees = new ArrayList<>();

        for(Employee employee:employeeList) {
            EmployeeResponseDTO dto = this.mapEmployeeToDTO(employee);
            employees.add(dto);
        }
        return employees;
    }

    @Override
    public EmployeeResponseDTO saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return this.mapEmployeeToDTO(savedEmployee);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()) {
            return this.mapEmployeeToDTO(employeeOptional.get());
        } else
            return null;
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Employee employee) {
        Employee updatedEmployee = employeeRepository.save(employee);
        return this.mapEmployeeToDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployeesByName(String name) {
//        List<Employee> employeeList = employeeRepository.findAll();
//        List<Employee> employeeList = employeeRepository.findByName(name);
//        List<Employee> employeeList = employeeRepository.findEmployeeByName(name);
        List<Employee> employeeList = employeeRepository.findEmpByName(name);
        List<EmployeeResponseDTO> employees = new ArrayList<>();

        for(Employee employee:employeeList) {
            EmployeeResponseDTO dto = this.mapEmployeeToDTO(employee);
            employees.add(dto);
        }
        return employees;
    }


    private EmployeeResponseDTO mapEmployeeToDTO(Employee employee) {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(employee.getId());
        employeeResponseDTO.setName(employee.getName());
        employeeResponseDTO.setDepartment(employee.getDepartment());
        return employeeResponseDTO;
    }
}
