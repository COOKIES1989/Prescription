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