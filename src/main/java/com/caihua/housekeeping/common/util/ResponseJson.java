package com.caihua.housekeeping.common.util;

import lombok.Data;

@Data
public class ResponseJson {
	private String code;

	private String msg;

	private Object body;

	public static ResponseJson success(String msg){
		ResponseJson responseJson=new ResponseJson("200",msg,null);
		return responseJson;
	}
	public static ResponseJson success(Object o){
		ResponseJson responseJson=new ResponseJson("200","",o);
		return responseJson;
	}
	public static ResponseJson error(String msg){
		ResponseJson responseJson=new ResponseJson("500",msg,"");
		return responseJson;
	}



	public ResponseJson(String code, String msg, Object body) {

		this.code = code;
		this.msg = msg;
		this.body = body;
	}
}
