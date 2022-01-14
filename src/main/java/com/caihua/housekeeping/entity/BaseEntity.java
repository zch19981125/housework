package com.caihua.housekeeping.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class BaseEntity {
	private Boolean isDelete;

	private Date createDate;

	private Date updateDate;
}
