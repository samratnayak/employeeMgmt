package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.Employees;
import com.project.dao.ExampleDAO;
import com.project.model.Dept;
import com.project.model.ExampleEmp;

@Service("exService")
public class ExampleService {
	
	private ExampleDAO exampleDAO;

	@Autowired
	public void setExampleDAO(ExampleDAO exampleDAO) {
		this.exampleDAO = exampleDAO;
	}
	
	
	@Transactional
    public List<ExampleEmp> listPersons() {
    	//System.out.println("exampleDAO "+exampleDAO);
        return this.exampleDAO.getEmployeeUsingHQL();
    }

	@Transactional
    public void setD() {
    	//System.out.println("exampleDAO "+exampleDAO);
        this.exampleDAO.setDeptUsingHQL();
    }

}
