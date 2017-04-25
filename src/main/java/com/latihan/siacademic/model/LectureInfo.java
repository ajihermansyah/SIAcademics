package com.latihan.siacademic.model;

import com.latihan.siacademic.enums.Position;

public class LectureInfo {

	private Integer id;
	private Integer NID;
	private String lectureName;
	private Integer major;
	private Position position;
	
	
	public LectureInfo() {
		
	}


	public LectureInfo(Integer id, Integer NID, String lectureName, Integer major, Position position) {
		this.id = id;
		this.NID = NID;
		this.lectureName = lectureName;
		this.major = major;
		this.position = position;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNID() {
		return NID;
	}


	public void setNID(Integer nID) {
		NID = nID;
	}


	public String getLectureName() {
		return lectureName;
	}


	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	
	public Integer getMajor() {
		return major;
	}


	public void setMajor(Integer major) {
		this.major = major;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}
	
}
