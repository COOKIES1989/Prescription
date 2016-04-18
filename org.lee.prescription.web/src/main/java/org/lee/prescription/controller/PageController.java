/**
 * 
 */
package org.lee.prescription.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description 用于跳转页面的控制器
 * @Date 2015年8月5日 下午2:55:16
 * @author lijw
 *
 */
@Controller
public class PageController {
	
	@RequestMapping("toypgl.do")
	public String toYpglPage (){
		System.out.println("跳转到药品管理页面");
		return "WEB-INF/jsp/ypgl";
	}
	
	
	@RequestMapping("tocfgl.do")
	public String toCfglPage (){
		System.out.println("跳转到处方管理页面");
		return "WEB-INF/jsp/cfgl";
	}
	
	@RequestMapping("toerror.do")
	public String toErrorPage (){
		System.out.println("跳转到处方管理页面");
		return "WEB-INF/jsp/error";
	}
	
	/**
	 * 跳转到主页面
	 * @return
	 */
	@RequestMapping("tomain.do")
	public String toMainPage (){
		return "WEB-INF/jsp/index";
	}
	
	
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMapping("tologin.do")
	public String toLoginPage(){
		System.out.println("跳转带登陆页面");
		return "WEB-INF/jsp/login";
	}
	
	
	
}
























