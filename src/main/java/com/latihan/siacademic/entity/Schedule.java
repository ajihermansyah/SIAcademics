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
@Table(name="Schedule")
public class Schedule implements Serializable {
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id;
	private Subject subj;
	private Room room;
	private Integer jam_masuk;
	private Integer jam_keluar;
	private String days;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="subj", nullable = false, foreignKey = @ForeignKey(name="schedule_fk1"))
	public Subject getSubj(){
		return subj;
	}
	
	public void setSubj(Subject subj){
		this.subj = subj;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="room", nullable = false, foreignKey = @ForeignKey(name="schedule_fk2"))
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room){
		this.room = room;
	}
	
	@Column(name="jam_masuk", nullable = false)
	public Integer getJam_masuk() {
		return jam_masuk;
	}
	
	public void setJam_masuk(Integer jam_masuk){
		this.jam_masuk = jam_masuk;
	}
	
	@Column(name="jam_keluar", nullable = false)
	public Integer getJam_keluar() {
		return jam_keluar;
	}
	
	public void setJam_keluar(Integer jam_keluar){
		this.jam_keluar = jam_keluar;
	}
	
	@Column(name="days", nullable = false)
	public String getDays() {
		return days;
	}
	
	public void setDays(String days){
		this.days = days;
	}

}
