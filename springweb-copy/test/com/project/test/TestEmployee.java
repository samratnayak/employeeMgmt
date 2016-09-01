package com.project.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.dao.EmpDAO;
import com.project.dao.UserDAO;
import com.project.model.User;
import com.project.service.EmpService;

@ContextConfiguration(locations = { "classpath:com/conf/security-context.xml",
		"classpath:com/test/conf/hbm-test-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEmployee {
	
	@Autowired
	private EmpDAO empSer;
	
	@Autowired
	private UserDAO usrDAO;
	
	@Test
	public void testCreateUser() {
		usrDAO.DeleteAllUsers();
		assertEquals("Equal", usrDAO.setUser(new User("samrat","samrat",true,"saa@gmail.com")).MIN_VALUE , new Integer(1).MIN_VALUE);
		assertEquals("No of existing users must be one.",usrDAO.showAllUser().size(),1);
		assertFalse("Employee should exist "+empSer.exists(125),empSer.exists(125));
		/*;
		//u.showAllUser();
		*/
		
	}

}
