package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Dept;
import com.project.model.ExampleEmp;

public class ExampleDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public List<ExampleEmp> getEmployeeUsingHQL() {

		Session session = sessionFactory.openSession();
		//System.out.println(session);
		 List<ExampleEmp> el = session.createQuery("from ExampleEmp").list();
		 for(ExampleEmp e:el){
			 System.out.println(e);
		 }
		 return el;
		

	}


	//@Transactional
	public void setDeptUsingHQL() {
		// TODO Auto-generated method stub
		
		Dept dep = new Dept();
		dep.setDesc("HR Dept");
		Session session = sessionFactory.openSession();
		session.persist(dep);
		session.flush();
	}

}
