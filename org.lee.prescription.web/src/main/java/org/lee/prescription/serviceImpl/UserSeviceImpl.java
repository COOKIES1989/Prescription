package org.lee.prescription.serviceImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.lee.prescription.model.User;
import org.lee.prescription.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSeviceImpl implements UserService{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public User findUser(User user) throws Exception {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		List<User> list = criteria.list();
		if (list == null || list.size()<= 0) {
			return null;
		}
		return list.get(0);
	}

	
	
	
	public String addUser(User user) throws Exception {
		return null;
	}

}












