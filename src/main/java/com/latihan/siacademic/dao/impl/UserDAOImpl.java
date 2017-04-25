package com.latihan.siacademic.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.latihan.siacademic.dao.UserDAO;
import com.latihan.siacademic.entity.User;
import com.latihan.siacademic.model.UserInfo;

public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User findUser(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", id));
		return (User) criteria.uniqueResult();
	}
	
	@Override
	public UserInfo findUserInfo(Integer id){
		User user = this.findUser(id);
		if(user == null){
			return null;
		}
		return new UserInfo(user.getId(), user.getUserId(), user.getPassword(),user.getUserStatus());
	}
	
	@Override
	public void saveUser(Integer userId, String userStatus) {
		
		User user = null;
		
		Session session = this.sessionFactory.getCurrentSession();

		if (userId != null) {
			user = this.findUser(userId);
		}
		
		boolean isNew = false;
		if(user == null ){
			isNew = true;
			user = new User();
		}
	
		user.setUserId(userId);
		user.setPassword("Default123");
		user.setUserStatus(userStatus);
		
		System.out.println("UID = "+userId);
		System.out.println("US = "+userStatus);
		
		if (isNew) {
			session.persist(user);
		}
	}
	
	@Override
	public void deleteUser(Integer id){
		User user = this.findUser(id);
		if(user != null){
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}

	
}
