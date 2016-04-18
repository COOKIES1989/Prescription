package org.lee.prescription.service;

import java.util.List;

/**
 * 权限管理接口
 * @author lijianwei
 *
 */
public interface AuthService {
	
	
	/**
	 * 通过用户ID获取该用户的权限
	 * @param usreid
	 * @return
	 */
	public List<String> getAuth(String userid);
	
	
	

}
