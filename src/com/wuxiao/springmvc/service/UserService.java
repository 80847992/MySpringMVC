package com.wuxiao.springmvc.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public boolean login(String username, String password) {
		if (username.equals("admin") && password.equals("123456")) {
			return true;
		}else {
			return false;
		}
	}

}
