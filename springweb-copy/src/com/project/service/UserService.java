package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDAO;
import com.project.model.User;

@Service("userservice")
public class UserService {


	private UserDAO userdao;
	
	@Autowired
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	public int SetUser(User user){
		
		return userdao.setUser(user);
	}

	public List<User> getEmp(){
		return userdao.showAllUser();
	}


}
