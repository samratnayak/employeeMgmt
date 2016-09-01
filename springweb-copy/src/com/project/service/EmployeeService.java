package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.dao.EmployeeDAOTest;
import com.project.dao.Employees;
import com.project.model.EmployeesTest;

@Service("employeeService")
public class EmployeeService {

	private EmployeeDAOTest empDao;
	
	public void setEmpDao(EmployeeDAOTest empDao) {
		this.empDao = empDao;
	}


	public List<EmployeesTest> getEmp(){
		return empDao.getEmployee();
	}
}
