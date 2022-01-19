package com.caihua.housekeeping.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Custom extends BaseEntity{

	@TableId(type = IdType.AUTO)
	private String id;

	private String name;

	private String sex;

	private String age;

	private String address;

	private String identityNum;
}
