package com.caihua.housekeeping.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caihua.housekeeping.entity.vo.ServiceVo;
import com.caihua.housekeeping.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
