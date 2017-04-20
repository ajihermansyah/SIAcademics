package com.latihan.siacademic.model;

import java.util.List;

public class StudentInfo {
	
	private Integer id;
	private Integer nim;
	private String studentName;
	private Integer tahun_angkatan;
	private String status;
	private Integer majorId;
	
	private List<MajorInfo> listMajor;
	
	public StudentInfo()
	{
		
	}
		
	public StudentInfo(Integer id,Integer nim, String studentName, Integer tahun_angkatan, String status, Integer majorId) {
		this.id = id;
		this.nim = nim;
		this.studentName = studentName;
		this.tahun_angkatan = tahun_angkatan;
		this.status = status;
		this.majorId = majorId;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getNim() {
		return nim;
	}
	public void setNim(Integer nim) {
		this.nim = nim;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getTahun_angkatan() {
		return tahun_angkatan;
	}
	public void setTahun_angkatan(Integer tahun_angkatan) {
		this.tahun_angkatan = tahun_angkatan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getMajorId() {
		return majorId;
	}
	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public List<MajorInfo> getListMajor() {
		return listMajor;
	}

	public void setListMajor(List<MajorInfo> listMajor) {
		this.listMajor = listMajor;
	}
}
