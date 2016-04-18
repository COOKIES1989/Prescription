package org.lee.prescription.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName : org.lee.info
 * @Classname :　ExceptionHandler
 * @Description : TODO 
 * @date 2015-7-21 下午2:18:43
 * @author lijw
 *
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver{

	/**
	 * 自定义异常处理方法
	 */
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception) {
		System.out.println("into ExceptionHandler's resolveException");
		System.out.println("异常信息："+exception.getMessage());
		Map<String, Object> model = new HashMap<String, Object>();
		ResultModel rm = new ResultModel();
		
		boolean isAjax = request.getHeader("X-Requested-With") != null;
		
		if (isAjax) {//是ajax请求
			System.out.println("=====ajax request=====");
			return new ModelAndView("error", model);
		}else{
			System.out.println("=====normal request=====");
			rm.setFlag("NO");
			model.put("model", rm);
			return new ModelAndView("error", model);
		}
		
		
		
	}
	
	
	
	

}














