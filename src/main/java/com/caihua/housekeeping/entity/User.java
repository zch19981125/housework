package com.caihua.housekeeping.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
public class User {
	private String id;

	private String username;

	private String password;

	private String remark;

	private Date createDate;

	private Date updateDate;


	public String getId() {

		return id;
	}


	public void setId(String id) {

		this.id = id;
	}


	public String getUsername() {

		return username;
	}


	public void setUsername(String username) {

		this.username = username;
	}


	public String getPassword() {

		return password;
	}


	public void setPassword(String password) {

		this.password = password;
	}


	public String getRemark() {

		return remark;
	}


	public void setRemark(String remark) {

		this.remark = remark;
	}


	public Date getCreateDate() {

		return createDate;
	}


	public void setCreateDate(Date createDate) {

		this.createDate = createDate;
	}


	public Date getUpdateDate() {

		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {

		this.updateDate = updateDate;
	}
}
