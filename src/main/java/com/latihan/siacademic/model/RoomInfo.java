package com.latihan.siacademic.model;


// coba update
public class RoomInfo {
	private Integer id;
	private String roomCode;
	private String roomName;
	
	public RoomInfo(){
		
	}
	
	public RoomInfo(Integer id, String roomCode, String roomName){
		this.id = id;
		this.roomCode = roomCode;
		this.roomName = roomName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	
	

}
