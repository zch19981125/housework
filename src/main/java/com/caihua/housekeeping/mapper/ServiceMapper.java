package com.caihua.housekeeping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caihua.housekeeping.entity.Service;
import com.caihua.housekeeping.entity.vo.ServiceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServiceMapper extends BaseMapper<Service> {

	List<ServiceVo> pageSearch(@Param("service")Service service, @Param("current")Integer current, @Param("size")Integer size);
}
