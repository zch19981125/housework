package com.caihua.housekeeping.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Service extends BaseEntity{

	@TableId(type = IdType.AUTO)
	private String id;

	private String serviceNum;

	private String address;

	private String money;

	private Date serviceDate;

	private String customId;

	private String dictId;
}
