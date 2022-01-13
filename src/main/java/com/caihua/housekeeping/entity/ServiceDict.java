package com.caihua.housekeeping.entity;

import lombok.Data;

@Data
public class ServiceDict extends BaseEntity{
	private Integer id;

	private String name;

	private String value;

	private String type;
}
