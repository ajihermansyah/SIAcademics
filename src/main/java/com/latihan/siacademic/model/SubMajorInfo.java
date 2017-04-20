package com.latihan.siacademic.model;

public class SubMajorInfo {
	private Integer id;
	private Integer subjectId;
	private Integer majorId;
	
	public SubMajorInfo() {
		
	}

	public SubMajorInfo(Integer id, Integer subjectId, Integer majorId) {
		this.id= id;
		this.subjectId = subjectId;
		this.majorId = majorId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

}
