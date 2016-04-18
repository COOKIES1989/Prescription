package org.lee.prescription.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginModel implements Serializable{

	private static final long serialVersionUID = -1844558083264741634L;
	
	public static Map<String, User> USER_MAP = new HashMap<String, User>();//用于缓存用户信息的map
	
	public static Map<String, List<String>> USER_AUTH_MAP = new HashMap<String, List<String>>();//用于缓存用户权限信息

	public static final int SUCCESS_CODE = 1001;//登陆成功代码标示
	
	public static final String SUCCESS_CODE_MSG = "登陆成功";//登陆成功代码含义
	
	public static final int FAILED_CODE = 1002;//登录失败代码
	
	public static final String FAILED_CODE_MSG = "登录失败,用户名或密码错误";//登录失败代码含义
	
	public static String COOKIE_NAME = "SSO_COOKIE";
	
	public static String TOKEN_NAME = "SSO_TOKEN";
	
	public static Map<String, String> USER_LOGIN_STATE = new HashMap<String, String>();//用户保存用户的登陆状态，主要用于判断是否已过期
	
	
	

	
	
	
	
	
	
	
	
	

	
}






























