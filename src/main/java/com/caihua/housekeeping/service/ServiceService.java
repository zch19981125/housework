package com.caihua.housekeeping.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caihua.housekeeping.common.util.EntityUtil;
import com.caihua.housekeeping.entity.vo.ServiceVo;
import com.caihua.housekeeping.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ServiceService extends ServiceImpl<ServiceMapper, com.caihua.housekeeping.entity.Service> {

	@Autowired
	ServiceMapper serviceMapper;

	public IPage pageSearch(Integer current, Integer size, com.caihua.housekeeping.entity.Service serviceEntity) {
		IPage page = new Page(current,size);
		List<ServiceVo> serviceVoList= serviceMapper.pageSearch(serviceEntity, current-1, size);
		page.setRecords(serviceVoList);
		page.setSize(size);
		page.setCurrent(current);
		return page;
	}

	@Transactional(readOnly = false)
	public boolean add(Map<String, Object> param) {

		EntityUtil.verifyObject(param,new ArrayList<>());
		List<Integer> peopleList = (List<Integer>) param.get("servicePeopleId");
		com.caihua.housekeeping.entity.Service o= JSON.parseObject(JSONObject.toJSONString(param), com.caihua.housekeeping.entity.Service.class);
		o.setIsDelete(false);
		o.setCreateDate(new Date());
		serviceMapper.insert(o);
		serviceMapper.insertServicePeople(Integer.parseInt(o.getId()),peopleList);

		return true;
	}
}
