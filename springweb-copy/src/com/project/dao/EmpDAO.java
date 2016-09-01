package com.project.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Employee;
@Repository
@Component("empDao")
public class EmpDAO {
	private SessionFactory sessionFactory;
	Logger logger  = Logger.getLogger(EmpDAO.class);

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Integer setEmp(Employee e) {
		
		Session session = sessionFactory.getCurrentSession();
		session.persist(e);
		session.flush();
		return e.getId();
	}
	
	public List<Employee> showAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> el;
		Session session = sessionFactory.getCurrentSession();
		el = session.createQuery("from Employee").list();
		session.flush();
		return el;
	}
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
		Employee e1;
		Session session = sessionFactory.getCurrentSession();
		e1 = session.load(Employee.class, new Integer(empId));
		session.flush();
		logger.debug("Employee DAO"+e1);
		return e1;
	}
	@Transactional
	public boolean exists(int empId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Employee.class);
		c.add(Restrictions.idEq(empId));
		Employee e1 = (Employee)c.uniqueResult();
		return e1!=null;
	}
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(emp);
		session.flush();
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Employee e1 = session.load(Employee.class, new Integer(id));
		session.delete(e1);
		session.flush();
	}
}
