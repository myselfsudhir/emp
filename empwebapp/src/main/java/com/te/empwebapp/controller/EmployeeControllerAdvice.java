package com.te.empwebapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.empwebapp.customexp.EmployeeException;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	public String handleExp(EmployeeException exception,HttpServletRequest req ) {
		req.setAttribute("errMsg", exception.getMessage());
		return "empLogin";
	}// 

}