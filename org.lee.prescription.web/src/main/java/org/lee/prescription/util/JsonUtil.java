package org.lee.prescription.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

	/**
	 * Json转换
	 * 
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) throws Exception {
		String jsonData = new Gson().toJson(object, new TypeToken<Object>() {
		}.getType());
		return jsonData;
	}

	/**
	 * Json转换
	 * 
	 * @param object
	 * @return
	 */
	public static String returnJson(Object object) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter stringWriter = new StringWriter();
		objectMapper.writeValue(stringWriter, object);

		String jsonStr = stringWriter.toString();
		return jsonStr;
	}

	// 调用json工具方法，传�?2个参数number，list
	public static String jsonUtil(int number, Object list) throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", number);
		jsonMap.put("rows", list);

		String returnJson = JsonUtil.returnJson(jsonMap);
		return returnJson;
	}
}
