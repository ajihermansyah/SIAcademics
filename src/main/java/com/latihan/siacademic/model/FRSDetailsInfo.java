package com.latihan.siacademic.model;

public class FRSDetailsInfo {

	private Integer id;
	private Integer frsId;
	private Integer subjectId;
	private String subjectName;
	private Integer sks;
	
	public FRSDetailsInfo(){
		
	}

	public FRSDetailsInfo(Integer id, Integer frsId, Integer subjectId, String subjectName, Integer sks) {
		super();
		this.id = id;
		this.frsId = frsId;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.sks = sks;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFrsId() {
		return frsId;
	}

	public void setFrsId(Integer frsId) {
		this.frsId = frsId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
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
	
}
