package com.latihan.siacademic.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name ="Student")
public class Student implements Serializable{
	
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id; 
	private Integer nim;
	private String studentName;
	private Integer tahun_angkatan;
	private String status;
	private Major major;
	
	public Student(){
		
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_student", nullable = false)
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	@Column(name = "nim", length = 10, nullable = false)
	public Integer getNim() {
		return nim;
	}

	public void setNim(Integer nim) {
		this.nim = nim;
	}

	@Column(name = "studentName", length = 50, nullable = false)
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "tahun_angkatan", length = 50, nullable = false)
	public Integer getTahun_angkatan() {
		return tahun_angkatan;
	}

	public void setTahun_angkatan(Integer tahun_angkatan) {
		this.tahun_angkatan = tahun_angkatan;
	}

	@Column(name = "status", length = 50, nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn (name="major", nullable = false, foreignKey = @ForeignKey(name="Student_fk1"))
	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}
	
}
