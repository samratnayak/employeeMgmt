package com.project.controllers;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(DataAccessException.class)
	public String handleDBError(DataAccessException ex){
		
		return "DbError";
	}
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessDenied(AccessDeniedException ex, Model model){
		model.addAttribute("error", "You dont have access!!!");
		return "error";
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public String handleConstraintViolation(ConstraintViolationException ex, Model model){
		model.addAttribute("error", "Username/Email exists");
		return "error";
	}
}
