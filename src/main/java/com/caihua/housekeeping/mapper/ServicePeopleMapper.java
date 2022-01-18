package com.caihua.housekeeping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caihua.housekeeping.entity.ServicePeople;
import com.caihua.housekeeping.entity.vo.ServicePeopleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServicePeopleMapper extends BaseMapper<ServicePeople> {
	List<ServicePeopleVo> listServicePeople(@Param("people") ServicePeople people, @Param("current")Integer current, @Param("size")Integer size);

	Integer countListServicePeople(@Param("people")ServicePeople people);
}
