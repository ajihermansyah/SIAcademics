package com.latihan.siacademic.dao;

import com.latihan.siacademic.entity.User;
import com.latihan.siacademic.model.UserInfo;

public interface UserDAO {

	public User findUser(Integer id);
	
	public void saveUser(Integer userId, String status);
	
	public UserInfo findUserInfo(Integer id);
	
	public void deleteUser(Integer id);	
	
}
