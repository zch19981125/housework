package com.caihua.housekeeping.controller;

import com.caihua.housekeeping.common.util.ResponseJson;
import com.caihua.housekeeping.entity.Service;
import com.caihua.housekeeping.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("service")
@ResponseBody
@CrossOrigin(
	origins = {"*"}
)
public class ServiceController {

	@Autowired
	ServiceService service;

	@RequestMapping("pageSearch")
	public ResponseJson pageSearch(Integer current, Integer size, Service serviceEntity){
		return ResponseJson.success(service.pageSearch(current,size,serviceEntity));
	}

}
