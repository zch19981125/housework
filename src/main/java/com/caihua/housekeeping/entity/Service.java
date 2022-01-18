package com.caihua.housekeeping.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Service extends BaseEntity{
	private String id;

	private String serviceNum;

	private String address;

	private String money;

	private Date serviceDate;
}
