package com.latihan.siacademic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Room")
public class Room implements Serializable {
	
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id;
	private String roomCode;
	private String roomName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	@Column(name="roomCode", length =50, nullable = false)
	public String getRoomCode() {
		return roomCode;
	}
	
	public void setRoomCode(String roomCode)
	{
		this.roomCode = roomCode;
	}
	
	@Column(name = "roomName", length = 50, nullable = false)
	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName){
		this.roomName = roomName;
	}
	
	
}
