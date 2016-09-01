package com.project.controllers;

import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	public static Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping("/home")
	public ModelAndView retunMyPage(@RequestParam( value="show",required=false)String show, Model model){
		
			//System.out.println("Value of show : "+show);
			//new EmployeeController().returnEmpPage(model);
			
		logger.debug("Home loaded");
		ModelAndView mav = new ModelAndView("NewFile");
		Map<String,Object> m  = mav.getModel();
		m.put("name", "Samrat");
		return mav;
	}

}
