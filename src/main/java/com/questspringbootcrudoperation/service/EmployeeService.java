package com.questspringbootcrudoperation.service;

import java.util.List;
import java.util.Optional;

import com.questspringbootcrudoperation.bean.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Optional<Employee> getEmployee(Integer empid);
	
	void deleteEmployee(Integer empid);

}
