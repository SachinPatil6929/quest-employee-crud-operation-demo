package com.questspringbootcrudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questspringbootcrudoperation.bean.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	

}
