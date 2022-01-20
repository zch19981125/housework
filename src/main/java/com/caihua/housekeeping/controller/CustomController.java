package com.caihua.housekeeping.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caihua.housekeeping.common.util.ResponseJson;
import com.caihua.housekeeping.entity.Custom;
import com.caihua.housekeeping.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("custom")
@ResponseBody
@CrossOrigin(
	origins = {"*"}
)
@Controller
public class CustomController {

	@Autowired
	CustomService customService;

	@RequestMapping("pageSearch")
	public ResponseJson pageSearch(IPage<Custom> page){
		return ResponseJson.success(customService.pageSearch(page));
	}

	@RequestMapping("add")
	public ResponseJson add(@RequestBody Custom custom){
		return ResponseJson.success(customService.add(custom));
	}
}
