package com.caihua.housekeeping.entity.vo;

import com.caihua.housekeeping.entity.Service;
import lombok.Data;

@Data
public class ServiceVo extends Service {
	private String custom;

	private String servicePeople;

	private String serviceType;
}
