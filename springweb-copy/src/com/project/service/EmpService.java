package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.EmpDAO;
import com.project.dao.ExampleDAO;
import com.project.model.Employee;

@Component("empService")
public class EmpService {
	

	@Autowired
	private EmpDAO empDAO;

	@PreAuthorize("hasAuthority('admin') ")
	@Transactional
	public Integer setEmp(Employee e){
		return empDAO.setEmp(e);
	}

	
	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empDAO.showAllEmp();
	}

	@PreAuthorize("hasAuthority('admin')")
	@Transactional
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
		return empDAO.getEmpById(empId);
	}
	@Transactional
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		empDAO.update(emp);
	}

	@Transactional
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		empDAO.delete(id);
		
	}
	@Transactional
	public boolean test(int id){
		return empDAO.exists(id);
	}
}
