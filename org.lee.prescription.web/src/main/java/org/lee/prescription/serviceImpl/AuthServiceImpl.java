package org.lee.prescription.serviceImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.lee.prescription.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//测试添加分支   李建威
	//添加分支之后的测试。。。。。。。2016年4月18日12:22:32
	 
	
	//add by lijw 2016-4-18 12:05:25
	public void test11111 (){
		System.out.println("just test");
	}
	
	
	
	
	//李建威添加
	public void test333333(){
		System.out.println("just test");
	}
	
	
	
	public void test0022 (){
		System.out.println("just t0022");
	}
	
	public void tttt(){
		System.out.println("just ttt");
	}
	
	
	
	public void test (){
		System.out.println("just test");
	}
	
	public List<String> getAuth(String userid) {
		String sql = "SELECT FU.ID FROM "+
				  "SYS_FUNCTION FU " + 
				  "INNER JOIN " +
				  "SYS_ROLE_FUNCTION RF " + 
				  " ON FU.ID =  RF.FUNCTONID " + 
				  "INNER JOIN SYS_USER_ROLE UR " +
				  " ON UR.ROLEID = RF.ROLEID " +
				  " WHERE UR.USERID = '" + userid + "'" ;
		SQLQuery sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> list = sqlQuery.list();
		return list;
		
	}

}
