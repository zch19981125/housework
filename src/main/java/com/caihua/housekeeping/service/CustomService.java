package com.caihua.housekeeping.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caihua.housekeeping.entity.Custom;
import com.caihua.housekeeping.mapper.CustomMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomService extends ServiceImpl<CustomMapper, Custom> {

	public IPage<Custom> pageSearch(IPage<Custom> page) {
		QueryWrapper<Custom> queryWrapper= Wrappers.query();
		queryWrapper.eq("is_delete",false);
		IPage<Custom> iPage=new Page<>(page.getCurrent(),page.getSize());
		iPage=page(iPage,queryWrapper);
		return iPage;
	}
}
