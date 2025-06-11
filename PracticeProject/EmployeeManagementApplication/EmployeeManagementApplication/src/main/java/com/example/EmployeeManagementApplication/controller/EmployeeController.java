package com.example.EmployeeManagementApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementApplication.dto.EmployeeResponseDTO;
import com.example.EmployeeManagementApplication.entity.Employee;
import com.example.EmployeeManagementApplication.service.EmployeeService;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    private ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        try {
            return ResponseEntity.ok(employeeService.getAllEmployees());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    private ResponseEntity<EmployeeResponseDTO> saveEmployee(@RequestBody Employee employee){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(employeeService.getEmployeeById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/")
    private ResponseEntity<EmployeeResponseDTO> updateEmployee(@RequestBody Employee employee){
        try {
            return ResponseEntity.ok(employeeService.updateEmployee(employee));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/")
    private ResponseEntity<Void> deleteEmployee(@RequestBody Employee employee){
        try {
            employeeService.deleteEmployee(employee);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/byName")
    private ResponseEntity<List<EmployeeResponseDTO>> getAllEmployeesByName(@RequestParam(name = "name") String name) {
        try {
            return ResponseEntity.ok(employeeService.getAllEmployeesByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
