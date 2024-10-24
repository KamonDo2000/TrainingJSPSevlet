package com.fa.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class SuperHandlingExceptionController {
	@ExceptionHandler(Exception.class)
	private String processGenericException(Model model, Exception ex) {
		model.addAttribute("exception", ex);
		return "adapterERR/ErrPage";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	private String processNotFounfException(Model model, Exception ex) {
		
		return "adapterERR/404";
	}

}