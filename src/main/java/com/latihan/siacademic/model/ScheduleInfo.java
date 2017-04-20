package com.latihan.siacademic.model;

public class ScheduleInfo {

	private Integer id;
	private Integer subj;
	private Integer room;
	private Integer jam_masuk;
	private Integer jam_keluar;
	private String date;

	public ScheduleInfo() {

	}

	public ScheduleInfo(Integer id, Integer subj, Integer room, Integer jam_masuk, Integer jam_keluar,
			String date) {
		this.id = id;
		this.subj = subj;
		this.room = room;
		this.jam_masuk = jam_masuk;
		this.jam_keluar = jam_keluar;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubj() {
		return subj;
	}

	public void setSubj(Integer subj) {
		this.subj = subj;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public Integer getJam_masuk() {
		return jam_masuk;
	}

	public void setJam_masuk(Integer jam_masuk) {
		this.jam_masuk = jam_masuk;
	}

	public Integer getJam_keluar() {
		return jam_keluar;
	}

	public void setJam_keluar(Integer jam_keluar) {
		this.jam_keluar = jam_keluar;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
