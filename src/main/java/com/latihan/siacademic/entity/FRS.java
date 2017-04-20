package com.latihan.siacademic.entity;

import java.io.Serializable;
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
@Table (name = "FRS")
public class FRS implements Serializable {
	
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id;
	private Student student;
	private String dosen_wali;
	private String tgl_frs;
	private String status;
	private String semester;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id", nullable=false)
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="student", nullable = false, foreignKey = @ForeignKey(name="FRS_fk2"))
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Column(name = "dosen_wali", length = 50, nullable = false)
	public String getDosen_wali() {
		return dosen_wali;
	}
	public void setDosen_wali(String dosen_wali) {
		this.dosen_wali = dosen_wali;
	}
	
	@Column(name = "tgl_frs", nullable = false)
	public String getTgl_frs() {
		return tgl_frs;
	}
	public void setTgl_frs(String date) {
		this.tgl_frs = date;
	}
	
	@Column(name = "status", length = 50, nullable = false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "semester", length = 50, nullable = false)
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}

}
