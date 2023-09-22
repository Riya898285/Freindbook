package com.webkorps.freindbook.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExc {
	
	@ExceptionHandler
	public String handleInvaliCredntials(InvalidCredentialsException ex,Model model)
	{
		model.addAttribute("error1","messageeee");
		return "loginpage"; 
	}
	
	
	
}
