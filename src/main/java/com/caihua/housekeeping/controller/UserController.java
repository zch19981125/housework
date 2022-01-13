package com.caihua.housekeeping.controller;

import com.caihua.housekeeping.entity.User;
import com.caihua.housekeeping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		List<User> userList=userService.list();
		return userList.toString();
	}

}
