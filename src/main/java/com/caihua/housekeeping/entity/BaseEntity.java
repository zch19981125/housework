package com.caihua.housekeeping.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class BaseEntity {
	private Boolean isDelete;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	private Date updateDate;
}
