package com.latihan.siacademic.dao;

import java.util.List;

public interface ReportDAO {

	public List<Object[]> reportMaxSubject();
	
	public List<Object[]> reportTop3MaxSubject();
	
	public List<Object[]> reportMaxStudent();
	
	public List<Object[]> reportSubject(Integer id);
	
	public List<Object[]> reportMaxSks(String semester);
}
