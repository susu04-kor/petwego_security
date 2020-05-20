package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;

public class MemberErrorController implements ErrorController {
	 
	private static final Logger LOGGER = LoggerFactory.getLogger(HandlerInterceptor.class);
		
	private static final String ERROR_PATH = "/login/error";
	     
	@Autowired
	private MessageSource messageSource;
	    
	@Override
	public String getErrorPath() {
	    return ERROR_PATH;
	}
	    
	@RequestMapping("/login/error")
	public String handleError(HttpServletRequest request, Model model) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	        
	    LOGGER.info("===================");
	    LOGGER.info(messageSource.getMessage("error.404 입니다", null, LocaleContextHolder.getLocale()));
	    LOGGER.info("===================");
	        
	    model.addAttribute("code", status.toString());
	        
	    return "/login/error";
	}
}
