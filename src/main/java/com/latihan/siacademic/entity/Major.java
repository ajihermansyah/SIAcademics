package com.latihan.siacademic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Major")
public class Major implements Serializable {
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id;
	private Integer majorCode;
	private String majorName;
	private String faculty;
	private String headMajor;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column (name="id", nullable = false)	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}

	@Column (name="majorCode", length = 10, nullable = false)
	public Integer getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(Integer majorCode) {
		this.majorCode = majorCode;
	}

	@Column (name="majorName", length = 50, nullable = false)
	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Column (name="faculty", length = 50, nullable = false)
	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@Column (name="headMajor", length = 50, nullable = false)
	public String getHeadMajor() {
		return headMajor;
	}

	public void setHeadMajor(String headMajor) {
		this.headMajor = headMajor;
	}
	
}
