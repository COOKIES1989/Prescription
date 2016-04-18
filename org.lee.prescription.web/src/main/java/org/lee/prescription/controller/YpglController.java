/**
 * 
 */
package org.lee.prescription.controller;

import javax.servlet.http.HttpServletResponse;

import org.lee.prescription.model.YPXXB;
import org.lee.prescription.service.YpglService;
import org.lee.prescription.util.PageUtil;
import org.lee.prescription.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName YpglController
 * @Description 药品管理controller
 * @Date 2015年8月5日 下午3:16:19
 * @author lijw
 *
 */
@Controller
@RequestMapping("/ypgl")
public class YpglController {
	
	@Autowired
	private YpglService ypglService;
	
	
	/**
	 * @Description 保存药品信息
	 * @param httpServletResponse
	 * @param ypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年8月6日 下午3:56:22
	 */
	@RequestMapping("/saveYpxx.do")
	@ResponseBody
	public ResultModel save_Ypxx(HttpServletResponse httpServletResponse , YPXXB ypxxb) throws Exception{
		ypglService.saveYpxx(ypxxb);
		return new ResultModel("OK", "保存成功");
	}
	
	/**
	 * @Description 查询所有的药品信息
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年8月6日 下午4:00:24
	 */
	@RequestMapping("/getAllYpxx.do")
	@ResponseBody
	public ResultModel getALLYpxx(PageUtil pageUtil) throws Exception{
		return ypglService.getAllYpxx(pageUtil);
	}
	
	/**
	 * @Description 删除药品信息
	 * @param ypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年8月10日 上午9:46:09
	 */
	@RequestMapping("/deleteYpxx.do")
	@ResponseBody
	public ResultModel delete_ypxx(YPXXB ypxxb) throws Exception{
		ypglService.deleteYpxx(ypxxb);
		return new ResultModel("OK", "删除成功");
	}
	
	/**
	 * 
	 * @Description 获取一条药品信息的详情
	 * @param ypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年8月10日 上午9:46:27
	 */
	@RequestMapping("/getOneYpxx.do")
	@ResponseBody
	public ResultModel get_OneYPxx (YPXXB ypxxb) throws Exception{
		YPXXB oneYpxx = ypglService.getOneYpxx(ypxxb);
		return new ResultModel("OK", "", 0, oneYpxx);
	}
	
	/**
	 * @Description 修改药品信息
	 * @param ypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年8月10日 上午9:46:57
	 */
	@RequestMapping("/updateYpxx.do")
	@ResponseBody
	public ResultModel update_ypxx (YPXXB ypxxb) throws Exception{
		ypglService.updateYpxx(ypxxb);
		return new ResultModel("OK", "修改成功");
	}
	
	

}




















