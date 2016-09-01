package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.User;

@Component("UserDao")
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public Integer setUser(User user) {
		// TODO Auto-generated method stub
		//Integer id;
		Session session = sessionFactory.openSession();
		//System.out.println(e);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session.persist(user);
		//id = session.createSQLQuery("select max(empid) from employee").getFirstResult();
		session.flush();
		//System.out.println();
		return user.getUserid();
	}
	@Transactional
	public List<User> showAllUser() {
		// TODO Auto-generated method stub
		List<User> users;
		Session session = sessionFactory.openSession();
 		users = session.createQuery("from User").list();
		/*for(Employee e:el){
			 System.out.println(e);
		 }*/
		session.flush();
		return users;
	}
 
	@Transactional
	public void DeleteAllUsers(){
		Session session = sessionFactory.openSession();
		session.createQuery("delete User").executeUpdate();
		session.flush();
	}

}
