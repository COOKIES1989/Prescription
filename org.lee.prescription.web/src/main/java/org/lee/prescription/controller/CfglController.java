/**
 * 
 */
package org.lee.prescription.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.lee.prescription.model.CFXXB;
import org.lee.prescription.model.CFYPXXB;
import org.lee.prescription.service.CfglService;
import org.lee.prescription.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName CfglController
 * @Description 处方管理控制器
 * @Date 2015年8月10日 上午10:41:52
 * @author lijw
 *
 */
@Controller
@RequestMapping("/cfgl")
public class CfglController {
	
	@Autowired
	private CfglService cfglService; 
	
	
	/**
	 * 
	 * @Description 模糊查询药品代码和药品全称
	 * @param response
	 * @param tbn
	 * @param value
	 * @return
	 * @throws Exception
	 * @autor LIJW
	 * @date 2015年9月9日 下午8:53:12
	 */
	@RequestMapping("/getYpxx.do")
	public String getYpxx(HttpServletResponse response , String tbn , String value) throws Exception {
		this.getRespWriter(response, cfglService.getYpxx(tbn , value));
		return null;
	}
	
	
	/**
	 * 
	 * @Description 保存药品信息
	 * @param response
	 * @param cfxxb
	 * @param cfypxxb
	 * @return
	 * @throws Exception
	 * @autor LIJW
	 * @date 2015年9月9日 下午8:53:57
	 */
	@RequestMapping("/saveCfxx.do")
	@ResponseBody
	public ResultModel saveCfxx(HttpServletResponse response , CFXXB cfxxb , CFYPXXB cfypxxb) throws Exception{
		String cfzj = cfglService.saveCfxx(cfxxb, cfypxxb);
		System.out.println(cfzj);
		return new ResultModel("0", cfzj);
	}
	
	
	/**
	 * @Description 追加处方药品
	 * @param cfypxxb
	 * @return
	 * @throws Exception 
	 * @autor lijw
	 * @date 2015年9月18日 下午6:58:23
	 */
	@RequestMapping("appendCfypxx.do")
	@ResponseBody
	public ResultModel saveMoreYpxx (CFYPXXB cfypxxb) throws Exception{
		String appendCfypzj = cfglService.saveMoreCfyp(cfypxxb);
		return new ResultModel("1", "添加成功");
	}
	
	/**
	 * 
	 * @Description 查询处方所含药品信息
	 * @param response
	 * @param cfzj
	 * @return
	 * @throws Exception 
	 * @autor JIANGMJ
	 * @date 2015年9月10日 下午5:39:55
	 */
	@RequestMapping("/getCfypxx.do")
	@ResponseBody
	public ResultModel getCfypxx (HttpServletResponse response , String cfzj) throws Exception{
		List<CFYPXXB> cfypxxs = this.cfglService.getCfypxx(cfzj); 
		return new ResultModel("0", "查询成功", cfypxxs.size(), cfypxxs);
	}
	
	
	/**
	 * 
	 * @Description 删除处方药品
	 * @param response
	 * @param cfzj
	 * @return
	 * @throws Exception
	 * @autor JIANGMJ
	 * @date 2015年9月10日 下午6:42:09
	 */
	@RequestMapping("/deleteCfypxx.do")
	@ResponseBody
	public ResultModel deleteCfypxx(HttpServletResponse response ,CFYPXXB cfypxxb) throws Exception{
		this.cfglService.deleteCfypxx(cfypxxb);
		return new ResultModel("0", "删除成功");
	}
	
	
	/**
	 * @Description 根据主键查询一条处方药品信息
	 * @param cfypxxb
	 * @return
	 * @throws Exception 
	 * @autor lijw
	 * @date 2015年9月18日 下午4:27:23
	 */
	@RequestMapping("getOneYpxx.do")
	@ResponseBody
	public ResultModel getOneYpxx(CFYPXXB cfypxxb) throws Exception{
		CFYPXXB cfypxx = cfglService.getOneCfypxx(cfypxxb);
		return new ResultModel("0", "", 0, cfypxx);
	}
	
	
	/**
	 * @Description 更新处方药品信息
	 * @param cfypxxb
	 * @return
	 * @throws Exception 
	 * @autor lijw
	 * @date 2015年9月18日 下午4:57:29
	 */
	@RequestMapping("updateCfypxx.do")
	@ResponseBody
	public ResultModel updateCfypxx(CFYPXXB cfypxxb) throws Exception{
		cfglService.updateCfypxx(cfypxxb);
		return new ResultModel("1", "更新成功");
	}
	
	
	
	
	
	/**
	 * response向页面返回数据s
	 * @param response
	 * @param object
	 * @throws IOException
	 */
	public void getRespWriter(HttpServletResponse response, Object object)
			throws IOException {
		response.setContentType("text/html");
		response.getWriter().print(object);
	}
	

}
