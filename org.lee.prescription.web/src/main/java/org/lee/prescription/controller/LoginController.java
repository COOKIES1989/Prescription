package org.lee.prescription.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lee.prescription.model.LoginModel;
import org.lee.prescription.model.User;
import org.lee.prescription.service.AuthService;
import org.lee.prescription.service.UserService;
import org.lee.prescription.util.ResultModel;
import org.lee.prescription.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;
	
	
	/**
	 * 登陆操作
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("login.do")
	public ResultModel login (HttpServletRequest request , HttpServletResponse response,
			User user) throws Exception{
		User userdb = userService.findUser(user);
		if (userdb != null) {
			List<String> auth = authService.getAuth(userdb.getUuid());
			
			LoginModel.USER_AUTH_MAP.put(userdb.getUuid(), auth);
			
			String token = StringUtil.getUUID();
			LoginModel.USER_MAP.put(token, userdb);
			Cookie cookie = new Cookie("LOGIN_TOKEN", token);
			response.addCookie(cookie);
			return new ResultModel(Integer.toString(LoginModel.SUCCESS_CODE), LoginModel.SUCCESS_CODE_MSG);
		}
		return new ResultModel(Integer.toString(LoginModel.FAILED_CODE), LoginModel.FAILED_CODE_MSG);
	}
	
	

}


























