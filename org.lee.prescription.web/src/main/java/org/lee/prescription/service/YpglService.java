package org.lee.prescription.service;

import java.util.List;

import org.lee.prescription.model.YPXXB;
import org.lee.prescription.util.PageUtil;
import org.lee.prescription.util.ResultModel;

public interface YpglService {
	
	/**
	 * 添加药品信息
	 * @Description TODO
	 * @param ypxxb
	 * @return
	 * @autor lijw
	 * @date 2015年8月5日 下午2:37:09
	 */
	public String saveYpxx(YPXXB ypxxb) throws Exception;
	
	/**
	 * 查询药品信息
	 * @Description TODO
	 * @param ypxxb
	 * @return
	 * @autor lijw
	 * @date 2015年8月5日 下午2:37:32
	 */
	public List<YPXXB> getYpxx(YPXXB ypxxb) throws Exception;
	
	/**
	 * 查询全部的药品信息
	 * @Description TODO
	 * @return
	 * @autor lijw
	 * @date 2015年8月5日 下午2:38:19
	 */
	public ResultModel getAllYpxx(PageUtil pageUtil) throws Exception;
	
	/**
	 * @Description 根据主键查询一条药品信息
	 * @param ypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年8月6日 下午5:15:53
	 */
	public YPXXB getOneYpxx(YPXXB ypxxb) throws Exception;
	
	
	
	/**
	 * 删除药品信息
	 * @Description TODO
	 * @param ypxxb
	 * @autor lijw
	 * @date 2015年8月5日 下午2:38:36
	 */
	public void deleteYpxx(YPXXB ypxxb) throws Exception;
	
	/**
	 * 更新药品信息
	 * @Description TODO
	 * @param ypxxb
	 * @autor lijw
	 * @date 2015年8月5日 下午2:38:56
	 */
	public void updateYpxx(YPXXB ypxxb) throws Exception;

}
