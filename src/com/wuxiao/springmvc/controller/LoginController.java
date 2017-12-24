package com.wuxiao.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.wuxiao.springmvc.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected HttpServletRequest request;
	
	@RequestMapping("login.do")
	public String login(@RequestParam(required=false) String username, @RequestParam(required=false) String password) {
		if (request.getMethod().equals("POST")) {
			if (userService.login(username, password)) {
				return "redirect:/success.do";
			}else {
				return "redirect:/error.do";
			}
		}
		return "login";
	}
	
	@RequestMapping("success.do")
	public String success() {
		return "success";
	}
	
	@RequestMapping("error.do")
	public String error() {
		return "error";
	}

}
