package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.coustomexception.IdAlreadyInException;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Repository

public class EmployeeDao {
	@Autowired
	EmployeeRepository er;
	
	public String setVal(List<Employee> p) {
		er.saveAll(p);
		return "Done";
	}
	
	public String setSalary(List<Employee> c) {
		er.saveAll(c);
		return "Sorry";
	}
	
	public String updateVal (Employee u) {
		er.save(u);
		return "Updated";
	}
	
	public Employee getId(int f) throws IdAlreadyInException{
		return er.findById(f).orElseThrow(()->new IdAlreadyInException("Exixt"));
	}

}

	