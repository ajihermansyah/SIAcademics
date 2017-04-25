package com.latihan.siacademic.model;

public class UserInfo {

	private Integer id;
	private Integer userId;
	private String password ;
	private String userStatus;
	
	public UserInfo(){
		
	}

	public UserInfo(Integer id, Integer userId, String password, String userStatus) {
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.userStatus = userStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
}
