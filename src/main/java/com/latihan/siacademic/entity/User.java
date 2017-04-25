package com.latihan.siacademic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Users")
public class User implements Serializable {
	private static final long serialVersionUID = -7893237204476214050L;
	
	private Integer id;
	private Integer userId;
	private String password;
	private String userStatus;
	
	public User(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	@Column(name="userId", nullable = false)
	public Integer getUserId(){
		return userId;
	}
	
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	
	@Column(name ="password", length = 20, nullable = false)
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	@Column(name = "userStatus", length = 50, nullable = false)
	public String getUserStatus(){
		return userStatus;
	}
	
	public void setUserStatus(String userStatus){
		this.userStatus = userStatus;
	}

}
