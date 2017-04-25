package com.latihan.siacademic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name =" Subject")

public class Subject implements Serializable {
	
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id;
	private String subjectCode;
	private String subjectName;
	private Integer sks;
	private Integer numberSemester;
	private String semester;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column (name = "id", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "subjectCode", length = 10, nullable = false)
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	@Column(name = "subjectName", length = 50, nullable = false)
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@Column(name = "sks", length = 50, nullable = false)
	public Integer getSks() {
		return sks;
	}
	public void setSks(Integer sks) {
		this.sks = sks;
	}
	
	@Column(name= "numberSemester", nullable = false)
	public Integer getNumberSemester(){
		return numberSemester;
	}
	
	public void setNumberSemester(Integer numberSemester){
		this.numberSemester = numberSemester;
	}
	
	@Column(name = "semester", length = 50, nullable = false)
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
}
