package com.latihan.siacademic.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.latihan.siacademic.enums.Position;
import com.sun.javafx.scene.control.skin.FXVK.Type;

@Entity 
@Table(name = "Lecture")
public class Lecture implements Serializable{
	
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id;
	private Integer NID;
	private String lectureName;
	private Major major;
	private Position position;
	
	public Lecture(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	@Column(name = "nid", length = 10, nullable = false)
	public Integer getNID() {
		return NID;
	}

	public void setNID(Integer NID) {
		this.NID = NID;
	}
	
	@Column(name = "lectureName", length = 10, nullable = false)
	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn (name="major", nullable = false, foreignKey = @ForeignKey(name="Student_fk1"))
	public Major getMajor(){
		return major;
	}
	
	public void setMajor(Major major){
		this.major = major;
	}
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "position", length = 10, nullable = false)
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}


	
	

	
	

}
