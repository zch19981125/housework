package com.caihua.housekeeping.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class ServicePeople extends BaseEntity{

	@TableId(type = IdType.AUTO)
	private Integer id;

	private List<Dict> dicts;

	private String name;

	private String sex;

	private String age;

	private String address;

	private String identityNum;
}