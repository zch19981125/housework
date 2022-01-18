package com.caihua.housekeeping.config;

import com.caihua.housekeeping.common.util.ResponseJson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody

public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ResponseJson exceptionHand(Exception e){
		ResponseJson responseJson=new ResponseJson("500",null,null);

		if(e instanceof RuntimeException){
			responseJson =ResponseJson.error(e.getMessage());
		}
		e.printStackTrace();
		return responseJson;
	}

}
