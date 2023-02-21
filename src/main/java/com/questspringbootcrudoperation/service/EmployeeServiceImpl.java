package com.questspringbootcrudoperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.questspringbootcrudoperation.bean.Employee;
import com.questspringbootcrudoperation.repository.EmployeeDao;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public void addEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	public List<Employee> listEmployeess() {
		List<Employee> list = employeeDao.findAll();
		return list;
	}

	public Optional<Employee> getEmployee(Integer empid) {
		return employeeDao.findById(empid);
	}

	public void deleteEmployee(Integer empid) {
		employeeDao.deleteById(empid);

	}

}
