package com.example.EmployeeManagementApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementApplication.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Custom Finder Method
    List<Employee> findByName(String name);

    //JPQL
    @Query("select e from Employee e where e.name= :n")
    List<Employee> findEmployeeByName(@Param("n") String name);

    //Native Query
    @Query(value = "select * from Employee where name= :n", nativeQuery = true)
    List<Employee> findEmpByName(@Param("n") String name);
}
