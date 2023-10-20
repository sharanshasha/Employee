package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;         
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.coustomexception.IdAlreadyInException;
import com.employee.coustomexception.SalaryNetValueException;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController

public class EmployeeController {
	@Autowired
	EmployeeService es;
	
	@PostMapping(path="/setAll")
	public String setVal(@RequestBody List<Employee> x) {
		return es.setVal(x);
	}
	
	@PostMapping(path="/setSal")
	public String setSalary(@RequestBody List<Employee> y)throws SalaryNetValueException {
		return es.setSalary(y);
	}
	
	@GetMapping(path="/geid/{y}")
	public Employee getId(@PathVariable int y) throws IdAlreadyInException {
		return es.getId(y);
	}
	
	
}
