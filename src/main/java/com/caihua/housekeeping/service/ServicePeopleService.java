package com.caihua.housekeeping.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caihua.housekeeping.entity.ServicePeople;
import com.caihua.housekeeping.entity.vo.ServicePeopleVo;
import com.caihua.housekeeping.mapper.ServicePeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	public IPage<ServicePeopleVo> pageSearch(Integer current,Integer size,ServicePeople people) {
		List<ServicePeopleVo> servicePeopleList=peopleMapper.listServicePeople(people, current-1, size);
		Integer total=peopleMapper.countListServicePeople(people);
		IPage<ServicePeopleVo> iPage=new Page<>(current,size);
		iPage.setTotal(total);
		iPage.setRecords(servicePeopleList);
		return iPage;
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
