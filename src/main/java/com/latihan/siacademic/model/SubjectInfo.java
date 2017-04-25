package com.latihan.siacademic.model;

import java.util.List;

public class SubjectInfo {

	private Integer id;
	private String subjectCode;
	private String subjectName;
	private Integer sks;
	private Integer numberSemester;
	private String semester;
	
	private List<FRSInfo> listMatKul;
	
	public SubjectInfo() {
		
	}

	public SubjectInfo(Integer id, String subjectCode, String subjectName, Integer sks, Integer numberSemester, String semester) {
		this.id = id;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.sks = sks;
		this.numberSemester = numberSemester;
		this.semester = semester;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getSks() {
		return sks;
	}

	public void setSks(Integer sks) {
		this.sks = sks;
	}
	
	public Integer getNumberSemester(){
		return numberSemester;
	}
	
	public void setNumberSemester(Integer numberSemester){
		this.numberSemester = numberSemester;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public List<FRSInfo> getListMatKul() {
		return listMatKul;
	}

	public void setListMatKul(List<FRSInfo> listMatKul) {
		this.listMatKul = listMatKul;
	}
	
}
