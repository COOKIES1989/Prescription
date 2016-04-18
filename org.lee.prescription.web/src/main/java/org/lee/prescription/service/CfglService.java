/**
 * 
 */
package org.lee.prescription.service;

import java.util.List;

import org.lee.prescription.model.CFXXB;
import org.lee.prescription.model.CFYPXXB;

/**
 * @ClassName CfglService
 * @Description 处方管理接口
 * @Date 2015年8月26日 下午9:20:46
 * @author LIJW
 *
 */
public interface CfglService {

	/**
	 * @Description 模糊查询药品信息
	 * @param tbn
	 * @param value
	 * @autor LIJW
	 * @date 2015年9月6日 下午8:32:01
	 */
	public String getYpxx(String tbn, String value) throws Exception;
	
	
	/**
	 * 
	 * @Description 保存处方信息，包括患者基本信息和处方药品信息
	 * @param cfxxb
	 * @param cfypxxb
	 * @return 处方信息主键
	 * @throws Exception
	 * @autor LIJW
	 * @date 2015年9月9日 下午8:33:58
	 */
	public String saveCfxx (CFXXB cfxxb , CFYPXXB cfypxxb) throws Exception ;
	
	
	/**
	 * 
	 * @Description 保存处方基本信息
	 * @param cfxxb
	 * @return 处方信息主键
	 * @throws Exception
	 * @autor LIJW
	 * @date 2015年9月9日 下午9:21:08
	 */
	public String saveCfjbxx(CFXXB cfxxb)throws Exception;
	
	
	/**
	 * @Description 追加处方药品信息
	 * @param cfypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年9月18日 下午6:59:54
	 */
	public String saveMoreCfyp(CFYPXXB cfypxxb) throws Exception;
	
	
	/**
	 * 
	 * @Description 根据处方主键查询处方所含药品信息
	 * @param cfzj
	 * @return 处方上所有的药品信息
	 * @throws Exception
	 * @autor JIANGMJ
	 * @date 2015年9月10日 下午5:32:34
	 */
	public List<CFYPXXB> getCfypxx(String cfzj)throws Exception;
	
	
	/**
	 * @Description 删除处方药品信息
	 * @param cfypxxb
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年9月18日 下午4:28:21
	 */
	public void deleteCfypxx(CFYPXXB cfypxxb) throws Exception;
	
	
	/**
	 * @Description 查询一条处方药品信息
	 * @param cfypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年9月18日 下午4:30:35
	 */
	public CFYPXXB getOneCfypxx (CFYPXXB cfypxxb) throws Exception;
	
	
	/**
	 * @Description 更新处方药品信息
	 * @param cfypxxb
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年9月18日 下午4:58:54
	 */
	public void updateCfypxx (CFYPXXB cfypxxb) throws Exception;

	
	

}








