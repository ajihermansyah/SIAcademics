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
@Table(name = "SubMajor")
public class SubMajor implements Serializable {
	
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id;
	private Major majorId;
	private Subject subjectId;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="majorId", nullable = false, foreignKey = @ForeignKey(name="SubMajor_fk1"))
	public Major getMajorId() {
		return majorId;
	}
	public void setMajorId(Major majorId) {
		this.majorId = majorId;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="subjectId", nullable = false, foreignKey = @ForeignKey(name="SubMajor_fk2"))
	public Subject getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}

}
