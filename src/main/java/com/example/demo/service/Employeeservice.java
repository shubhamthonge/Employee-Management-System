package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Employee;
import com.example.demo.repo.Employeerepo;

@Service
public class Employeeservice {

	@Autowired
	Employeerepo employeerepo;

	public Employeeservice() {
		System.out.println("inside Employeeservice const");
	}

	public Employee create(Employee e) {
		System.out.println("inside Employeeservice create");
		Employee e1 = employeerepo.save(e);
		return e1;
	}

	public Iterable<Employee> getall(Employee e) {
		System.out.println("inside Employeeservice getall");
		Iterable<Employee> e1 = employeerepo.findAll();
		System.out.println(e1);
		return e1;
	}

	public Employee getid(int id) {
		System.out.println(" inside Employeeservice getid");
		Optional<Employee> e = employeerepo.findById(id);
		if (e.isPresent()) {
			System.out.println("id is present " + id);
			Employee si = e.get();
			System.out.println(si);
			return si;
		} else {
			System.out.println("id is not present " + id);
			return new Employee();
		}

	}

	public Employee update(Employee emp) {
		Employee empupdate = new Employee();
		Optional<Employee> emp1 = employeerepo.findById(emp.getId());

		if(emp1.isPresent()) {
		Employee empdb=emp1.get();
			System.out.println("employee from db"+empdb);
			empupdate.setId(empdb.getId());
		
			if(emp.getName()==null){
				
				System.out.println("no name from UI");
				empupdate.setName(empdb.getName());
			}else {
				
				System.out.println(" name from UI");
				empupdate.setName(emp.getName());
			  }
				if (emp.getCompany()==null){
					System.out.println("no company from UI");
					empupdate.setCompany(empdb.getCompany());
				}else {
					System.out.println("company from UI");
					empupdate.setCompany(emp.getCompany());
				}
				System.out.println("final output"+ empupdate);
				Employee e= employeerepo.save(empupdate);
				return e;
		  }else{
			System.out.println("employee is not present "+ emp.getId());
			return null;
		}
	}
}
