package com.latihan.siacademic.model;

public class FRSInfo {

	private Integer id;
	private Integer studentId;
	private Integer nim;
	private String name;
	private String dosen_wali;
	private String tgl_frs;
	private String status;
	private String semester;
	
	public FRSInfo() {
		
	}

	public FRSInfo(Integer id, Integer studentId,Integer nim,String name, String dosen_wali, String tgl_frs, String status, String semester) {
		this.id = id;
		this.studentId = studentId;
		this.nim = nim;
		this.name = name;
		this.dosen_wali = dosen_wali;
		this.tgl_frs = tgl_frs;
		this.status = status;
		this.semester = semester;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

//	public Integer getSubjectId() {
//		return subjectId;
//	}
//
//	public void setSubjectId(Integer subjectId) {
//		this.subjectId = subjectId;
//	}

	public Integer getNim() {
		return nim;
	}

	public void setNim(Integer nim) {
		this.nim = nim;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDosen_wali() {
		return dosen_wali;
	}

	public void setDosen_wali(String dosen_wali) {
		this.dosen_wali = dosen_wali;
	}

	public String getTgl_frs() {
		return tgl_frs;
	}

	public void setTgl_frs(String date) {
		this.tgl_frs = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	
}
