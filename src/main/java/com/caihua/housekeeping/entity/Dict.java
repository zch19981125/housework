package com.caihua.housekeeping.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Dict extends BaseEntity{
	@TableId(type = IdType.AUTO)
	private Integer id;

	private String name;

	private String value;

	private String type;

	@TableField("`order`")
	private String order;
}
