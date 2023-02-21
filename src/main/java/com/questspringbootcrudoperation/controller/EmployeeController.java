package com.questspringbootcrudoperation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.questspringbootcrudoperation.bean.Employee;
import com.questspringbootcrudoperation.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute("command") Employee employee, 
			BindingResult result) {
		Employee emp = prepareModel(employee);
		employeeService.addEmployee(employee);
		return ModelAndView("redirect:/add.html");
		}
	@GetMapping("/employees")
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}
	@GetMapping("/add")
	public ModelAndView addEmployee(@ModelAttribute("command")  Employee employee,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	@PutMapping("/edit")
	public ModelAndView editEmployee(@ModelAttribute("command")  Employee employee,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employee.getId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable (value = "id") int id) {
		employeeService.deleteEmployee(id);
		
	}
	private Employee prepareModel(Employee emp){
		Employee employee = new Employee();
		employee.setAddress(employee.getAddress());
		employee.setAge(employee.getAge());
		employee.setName(employee.getName());
		employee.setSalary(employee.getSalary());
		employee.setId(employee.getId());
		employee.setId(null);
		return employee;
	}
	
	private List<Employee> prepareListofBean(List<Employee> employees){
		List<Employee> beans = null;
		if(employees != null && !employees.isEmpty()){
			beans = new ArrayList<Employee>();
			Employee bean = null;
			for(Employee employee : employees){
				bean = new Employee();
				bean.setName(employee.getName());
				bean.setId(employee.getId());
				bean.setAddress(employee.getAddress());
				bean.setSalary(employee.getSalary());
				bean.setAge(employee.getAge());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private Employee prepareEmployeeBean(Optional<Employee> employee){
		Employee bean = new Employee();
		bean.setAddress(employee.getAddress());
		bean.setAge(employee.getAge());
		bean.setName(employee.getName());
		bean.setSalary(employee.getSalary());
		bean.setId(employee.getId());
		return bean;
	}

}
