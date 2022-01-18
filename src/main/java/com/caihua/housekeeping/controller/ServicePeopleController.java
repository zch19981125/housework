package com.caihua.housekeeping.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caihua.housekeeping.common.util.ResponseJson;
import com.caihua.housekeeping.entity.ServicePeople;
import com.caihua.housekeeping.service.ServicePeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("servicePeople")
@Controller
@ResponseBody
@CrossOrigin(
	origins = {"*"}
)
public class ServicePeopleController{

	@Autowired
	ServicePeopleService peopleService;

	@RequestMapping("pageSearch")
	public ResponseJson pageSearch(Integer current,Integer size,ServicePeople people){
		return ResponseJson.success(peopleService.pageSearch(current,size,people));
	}
}
