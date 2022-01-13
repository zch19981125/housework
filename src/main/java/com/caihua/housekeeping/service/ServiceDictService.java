package com.caihua.housekeeping.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caihua.housekeeping.entity.ServiceDict;
import com.caihua.housekeeping.mapper.ServiceDictMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceDictService extends ServiceImpl<ServiceDictMapper, ServiceDict> {

	@Transactional(readOnly = false)
	public Boolean insetServiceDict(ServiceDict dict){
		this.save(dict);
		return true;
	}
}
