package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Employee;

@Repository
public interface Employeerepo extends CrudRepository<Employee, Integer> {

}
