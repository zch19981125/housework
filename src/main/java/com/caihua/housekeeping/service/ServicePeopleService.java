package com.caihua.housekeeping.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caihua.housekeeping.common.util.EntityUtil;
import com.caihua.housekeeping.entity.ServicePeople;
import com.caihua.housekeeping.entity.vo.ServicePeopleVo;
import com.caihua.housekeeping.mapper.ServicePeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * //todo
 *
 * <pre>
 * //todo
 * </pre>
 *
 * @author zch
 * @since $
 */
@Service
public class ServicePeopleService extends ServiceImpl<ServicePeopleMapper, ServicePeople> {

	@Autowired
	private ServicePeopleMapper peopleMapper;


	public IPage<ServicePeopleVo> pageSearch(Integer current, Integer size, ServicePeople people) {

		List<ServicePeopleVo> servicePeopleList = peopleMapper.listServicePeople(people, current - 1, size);
		Integer total = peopleMapper.countListServicePeople(people);
		IPage<ServicePeopleVo> iPage = new Page<>(current, size);
		iPage.setTotal(total);
		iPage.setRecords(servicePeopleList);
		return iPage;
	}


	@Transactional(readOnly = false)
	public Boolean add(Map<String, Object> servicePeopleMap) {

		EntityUtil.verifyObject(servicePeopleMap, new ArrayList<>());
		List<String> dicts = (List<String>) servicePeopleMap.get("dicts");
		servicePeopleMap.remove("dicts");
		ServicePeople servicePeople = JSONObject.parseObject(JSONObject.toJSONString(servicePeopleMap), ServicePeople.class);
		servicePeople.setIsDelete(false);
		servicePeople.setCreateDate(new Date());
		save(servicePeople);
		peopleMapper.insertPeopleDict(servicePeople.getId(), dicts);
		return true;
	}
	// ~ Static Fields
	// ==================================================================================================================

	// ~ Fields
	// ==================================================================================================================

	// ~ Constructors
	// ==================================================================================================================

	// ~ Methods
	// ==================================================================================================================
}
