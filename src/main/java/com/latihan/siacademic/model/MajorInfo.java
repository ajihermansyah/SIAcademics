package com.latihan.siacademic.model;

import java.util.List;

public class MajorInfo {

	private Integer id;
	private Integer majorCode;
	private String majorName;
	private String faculty;
	private String headMajor;

	private List<SubMajorInfo> listJur;

	public MajorInfo() {

	}

	public MajorInfo(Integer id, Integer majorCode, String majorName, String faculty,
			String headMajor) {
		this.id = id;
		this.majorCode = majorCode;
		this.majorName = majorName;
		this.faculty = faculty;
		this.headMajor = headMajor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(Integer majorCode) {
		this.majorCode = majorCode;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getHeadMajor() {
		return headMajor;
	}

	public void setHeadMajor(String headMajor) {
		this.headMajor = headMajor;
	}

	public List<SubMajorInfo> getListJur() {
		return listJur;
	}

	public void setListJur(List<SubMajorInfo> listJur) {
		this.listJur = listJur;
	}

}
