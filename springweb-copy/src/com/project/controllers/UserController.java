package com.project.controllers;

import java.sql.SQLException;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.User;
import com.project.service.UserService;

@Controller
public class UserController {

	private UserService userser;
	
	@Autowired(required=true)
    @Qualifier(value="userservice")
    public void setUserser(UserService userser){
        this.userser = userser;
    }
	
	@RequestMapping("/displayUserForm")
	public String displayUserForm(Model model){
		model.addAttribute("user", new User());
		return "userForm";
	}
	
	@RequestMapping(name="/createUser", method=RequestMethod.POST)
	public String addUser(Model model,@Valid User user, BindingResult res ){
		if(!res.hasErrors()){
			model.addAttribute("username",user.getUsername());
			model.addAttribute("userid",userser.SetUser(user));
			return "usersuccess";
		}
		else
			return "userForm";		
	}
	@RequestMapping("/mylogin")
	public String loadLoginPage(Model model,  @RequestParam( value="error",required=false )String err){
		if(err!=null){
			System.out.println(err);
			model.addAttribute("errorMsg", "Login Failed");
		}
		
		return "login";
	}
	
}
