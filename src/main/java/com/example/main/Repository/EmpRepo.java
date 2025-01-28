package com.example.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.Entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
