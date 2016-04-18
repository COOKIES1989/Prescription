package org.lee.prescription.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lee.prescription.model.LoginModel;
import org.lee.prescription.model.User;


/**
 * TODO web.xml中没有配置过滤器
 * 2015年11月26日16:41:30  
 * @author lijianwei
 *
 */
public class LoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String servletPath = request.getServletPath();
		if("/tologin.do".equals(servletPath) || "/login.do".equals(servletPath)){
			chain.doFilter(request, response);
			return;
		}
		
		String token = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length >= 0) {
			for (Cookie cookie : cookies) {
				if("LOGIN_TOKEN".equals(cookie.getName())){
					token = cookie.getValue();
				}
			}
		}
		
		User user = null;
		if (StringUtil.validStr(token)) {
			user = LoginModel.USER_MAP.get(token);
		}
		if(user == null){
			String loginUrl = "tologin.do";
			response.sendRedirect(loginUrl);
		}else{
			chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	

}
