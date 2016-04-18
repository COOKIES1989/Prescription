package org.lee.prescription.service;

import org.lee.prescription.model.User;

public interface UserService {
	
	
	/**
	 * 查找用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser (User user) throws Exception;
	
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String addUser (User user) throws Exception;
	
	
	

}
