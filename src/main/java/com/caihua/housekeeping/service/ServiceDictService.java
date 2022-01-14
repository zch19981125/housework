package com.caihua.housekeeping.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caihua.housekeeping.common.util.EntityUtil;
import com.caihua.housekeeping.entity.Dict;
import com.caihua.housekeeping.mapper.ServiceDictMapper;
import com.sun.xml.internal.ws.util.StringUtils;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

@Service
public class ServiceDictService extends ServiceImpl<ServiceDictMapper, Dict> {

	@Transactional(readOnly = true)
	public IPage<Dict> pageList(Integer current,Integer size,Dict dict){
		if(StringUtil.isNullOrEmpty(dict.getType())) throw new RuntimeException();

		QueryWrapper<Dict> dictQueryWrapper= Wrappers.query();
		if (!StringUtil.isNullOrEmpty(dict.getName())) {
			dictQueryWrapper.like("name",dict.getName());
		}
		if(!StringUtil.isNullOrEmpty(dict.getValue())){
			dictQueryWrapper.eq("value",dict.getValue());
		}
		dictQueryWrapper.eq("type",dict.getType());
		dictQueryWrapper.orderByAsc("'order'");
		IPage<Dict> page = new Page<>(current, size);
		return this.page(page,dictQueryWrapper);
	}

	@Transactional(readOnly = false)
	public Boolean saveServiceDict(Dict dict) {
		boolean isVerify=EntityUtil.verifyObject(dict, Arrays.asList(new String[]{"createDate","updateDate","id","isDelete"}));
		if(!isVerify) throw new RuntimeException("缺少必要参数");
		dict.setIsDelete(false);
		dict.setCreateDate(new Date());
		this.save(dict);
		return true;
	}



}
