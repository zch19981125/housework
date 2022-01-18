package com.caihua.housekeeping.entity;

import lombok.Data;

import java.util.List;

@Data
public class ServicePeople extends BaseEntity{

	private Integer id;

	private List<Dict> dicts;

	private String name;

	private String sex;

	private String age;

	private String address;

	private String identityNum;
}
