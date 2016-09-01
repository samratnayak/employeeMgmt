package com.project.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Employee;
import com.project.model.Iou;
import com.project.model.Message;
import com.project.service.EmpService;
import com.project.service.IouService;
import com.project.service.MessageService;

@Controller
public class EmployeeController {
	
	public static Logger logger = Logger.getLogger(EmployeeController.class);
	
	private EmpService empService;
	private IouService iouSer;
	
	List<Iou> iouList;

	

	@Autowired(required=true)
    @Qualifier(value="empService")
    public void setEmpService(EmpService emp){
        this.empService = emp;
    }
	@Autowired(required=true)
    @Qualifier(value="iouService")
    public void setIouService(IouService iouSer){
        this.iouSer = iouSer;
    }
	
	@RequestMapping("/addEmp")
	public String addEmp(Model model){
		iouList = iouSer.getAllIou();
		model.addAttribute("ious", iouList);
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	} 
	@RequestMapping("/")
	public ModelAndView retunMyPage(@RequestParam( value="show",required=false)String show, Model model){		
		logger.debug("Home loaded");
		ModelAndView mav = new ModelAndView("NewFile");
		Map<String,Object> m  = mav.getModel();
		List<Employee> eList = empService.getAllEmployees();
		
		m.put("empList", eList);
		return mav;
	}

	@RequestMapping(value="/createEmp", method=RequestMethod.POST  )
	public String createEmp(Model model,@Valid Employee emp, BindingResult res){	
		Employee e = new Employee(emp.getName(),emp.getIou(), emp.getEmail());
		Integer generatedEmpId=0;
		logger.debug("Employee "+emp+" res.hasErrors() "+res.hasErrors());
		
		if(res.hasErrors()){
			List<ObjectError> er = res.getAllErrors();
			for(ObjectError err:er){
				System.out.println(err.getDefaultMessage());
			}
			model.addAttribute("ious", iouSer.getAllIou());
			return "addEmployee";
		}
		else{
			if(emp.getId()!=0){
				empService.updateEmp(emp);
				List<Employee> eList = empService.getAllEmployees();
				model.addAttribute("empList", eList);
				return "empList";
			}
			else{
				generatedEmpId = empService.setEmp(e);
				//System.out.println(generatedEmpId);
				model.addAttribute("empId", generatedEmpId);
			}
		
	}
		return "EmpCreated";
	} 
	@RequestMapping("/employees")
	public String returnEmpPage(Model model, @RequestParam( name="delete",required=false)String delete){
		List<Employee> eList = empService.getAllEmployees();
		model.addAttribute("empList", eList);
		if(delete!=null)
			model.addAttribute("delete", delete);
		return "empList";
	}
	@RequestMapping(value="/editEmp/{id}")
	public String editEmp(Model model, @PathVariable("id")int empId){
		Employee e = empService.getEmpById(empId);
		List<Iou> iouList = iouSer.getAllIou();
		model.addAttribute("ious", iouList);
		model.addAttribute("employee", e);
		logger.debug("Employee "+e);
		return "editEmployee";
	} 
	
	/*@RequestMapping(value="/editEmp/test")
	public String test(Model model){
		logger.debug("Testing criteria "+empService.test(125));
		
		return "editEmployee";
	} */
	
	@RequestMapping("/dept")
	public String createDept(Model model){
		
		Employee e = new Employee("Samrat Nayak", 2, "samrat.nayak1@outlook.com");
		empService.setEmp(e); 
		return "NewFile";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST )
	public String deleteEmp(HttpServletRequest req)
	{
		String [] empIds = req.getParameterValues("deleteCheck");
		logger.debug("Inside testUrl ");
		if(empIds!=null){
		for(String s: empIds){
			logger.debug("Delete check "+s);
			if(s!=null)
			empService.deleteEmp(Integer.parseInt(s.trim()));
			
		}
		return "redirect:/employees?delete="+empIds[0];
		}
		
		return "redirect:/employees";
	}
	
}
