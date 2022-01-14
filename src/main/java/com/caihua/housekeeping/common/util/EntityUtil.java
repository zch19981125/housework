package com.caihua.housekeeping.common.util;

import com.alibaba.fastjson.JSONObject;
import io.netty.util.internal.StringUtil;

import java.util.List;
import java.util.Map;

public class EntityUtil {

	public static Boolean verifyObject(Object o,List<String> allowEmptyFild){

		String jsonObject = JSONObject.toJSONString(o);
		Map<String,Object> object=JSONObject.parseObject(jsonObject, Map.class);
		for(String key: object.keySet()){
			if(allowEmptyFild.contains(key)){
				continue;
			}

			Object o1=object.get(key);
			if(o1 instanceof String){
				if(StringUtil.isNullOrEmpty((String) o1)) throw new RuntimeException(key+"不能为空");
			}
			if(o1 instanceof List){
				if(o1==null||((List) o1).size()<=0) throw new RuntimeException(key+"不能为空");
			}
			if(o1 instanceof Integer) {
				if(o1 == null) throw new RuntimeException(key+"不能为空");
			}
		}
		return true;
	}
}
