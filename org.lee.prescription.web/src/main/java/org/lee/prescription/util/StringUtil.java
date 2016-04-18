package org.lee.prescription.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * @ClassName StringUtil
 * @Description 字符串工具类
 * @Date 2015年9月9日 下午9:06:40
 * @author LIJW
 */
public class StringUtil {

	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		// 生成uuid
		String uuid = String.valueOf(UUID.randomUUID()).replaceAll("\\-", "");
		return uuid;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean validStr(String str) {
		if (str != null && !"".equals(str) && !"null".equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 自动累加顺序号
	 * 
	 * @param no
	 * @return
	 */
	public static String getNumber(String no) {
		String rep = "01";
		if (validStr(no)) {
			rep = no.substring(0, 1);
			if (rep.equals("0")) {
				int req = Integer.valueOf(no.substring(1, 2));
				if (req == 9) {
					rep = String.valueOf(req + 1);
				} else {
					rep = "0" + String.valueOf(req + 1);
				}
			} else {
				rep = String.valueOf(Integer.valueOf(no) + 1);
			}
		}
		return rep;
	}
	
	/**
	 * 
	 * @Description 获取当前系统日期字符串yyyyMMdd HHmmss
	 * @param date
	 * @return
	 * @autor JIANGMJ
	 * @date 2015年9月10日 下午4:49:59
	 */
	public static String getSysDateStr (Date date){
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}
		return null;
	}


}











