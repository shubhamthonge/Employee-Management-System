package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;
import com.example.demo.service.Employeeservice;

@RestController

public class EmployeeController {

	@Autowired
	Employeeservice employeeservice;
	
	public EmployeeController() {	
		System.out.println("inside employeeController const");
	}
	
	@GetMapping("/getall")
	public Iterable<Employee> getall(@RequestBody Employee e) {
		System.out.println("inside EmployeeController getname ");
		Iterable<Employee> e1=employeeservice.getall(e);
		return e1;
	}
	
	@GetMapping("/getid")
	public Employee getid(@RequestParam ("id") int id) {
		System.out.println("inside EmployeeController getid");
		Employee e=employeeservice.getid(id);
		return e;
	}
	
	@PostMapping("/create")
	public Employee create(@RequestBody Employee e) {
		System.out.println("inside EmployeeController create");
		Employee e1=employeeservice.create(e);
		return e1;
	}
	 
	@PutMapping("/update")
	public Employee update(@RequestBody Employee e) {
	System.out.println("inside update");
	Employee emp=employeeservice.update(e);
	return emp;
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable ("id") int sid) {
		System.out.println("inside delete id is="+sid);
		
	}
}
