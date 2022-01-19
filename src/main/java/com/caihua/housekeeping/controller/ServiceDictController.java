package com.caihua.housekeeping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.caihua.housekeeping.common.util.ResponseJson;
import com.caihua.housekeeping.entity.Dict;
import com.caihua.housekeeping.service.ServiceDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
	public ResponseJson addServiceDict(@RequestBody Dict dict){
		Boolean result =dictService.saveServiceDict(dict);
		return ResponseJson.success(result);
	}

	@RequestMapping("del")
	public ResponseJson delServiceDict(Dict dict){
		return ResponseJson.success(dictService.removeById(dict.getId()));
	}

	@RequestMapping("list")
	public ResponseJson listServiceDict(Dict dict, IPage<Dict> page){
		return ResponseJson.success(dictService.pageList(Integer.parseInt(String.valueOf(page.getCurrent())), Integer.parseInt(String.valueOf(page.getSize())), dict));
	}

	@RequestMapping("listServiceDict")
	public ResponseJson list(Dict dict, IPage<Dict> page){

		QueryWrapper<Dict> dictQueryWrapper= Wrappers.query();
		dictQueryWrapper.eq("type","1");
		dictQueryWrapper.eq("is_delete","0");
		return ResponseJson.success(dictService.list(dictQueryWrapper));
	}

}
