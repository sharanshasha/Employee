package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.coustomexception.IdAlreadyInException;
import com.employee.coustomexception.SalaryNetValueException;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
@Service

public class EmployeeService {
	@Autowired
	EmployeeDao ed;
	
	public String setVal(@RequestBody List<Employee> o) {
		return ed.setVal(o);
	}
	
	public String setSalary(List<Employee> x) throws SalaryNetValueException{
		List<Employee> ab = x.stream().filter(a->a.getSalary()<50000).toList();
		if(ab.isEmpty()) {
			throw new SalaryNetValueException("No");
		}
		else {
			return ed.setSalary(ab);
		}
	}
	
	public Employee getId(int c) throws IdAlreadyInException {
		return ed.getId(c);
	}
	
	

}

