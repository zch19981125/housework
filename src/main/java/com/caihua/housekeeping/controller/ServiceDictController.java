package com.caihua.housekeeping.controller;

import com.alibaba.fastjson.JSONObject;
import com.caihua.housekeeping.common.util.ResponseJson;
import com.caihua.housekeeping.entity.ServiceDict;
import com.caihua.housekeeping.service.ServiceDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("serviceDict")
@ResponseBody
@CrossOrigin(
	origins = {"*"}
)
public class ServiceDictController {

	@Autowired
	ServiceDictService dictService;

	@RequestMapping("add")
	public ResponseJson addServiceDict(ServiceDict dict){
		return ResponseJson.success(dictService.save(dict));
	}

	@RequestMapping("del")
	public ResponseJson delServiceDict(ServiceDict dict){
		return ResponseJson.success(dictService.removeById(dict.getId()));
	}

	@RequestMapping("list")
	public ResponseJson listServiceDict(ServiceDict dict,Integer current,Integer num){
		return ResponseJson.success(dictService.list());
	}

}
