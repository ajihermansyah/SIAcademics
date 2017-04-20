package com.latihan.siacademic.dao;

import java.util.List;

import com.latihan.siacademic.entity.FRS;
import com.latihan.siacademic.entity.Student;
import com.latihan.siacademic.model.FRSInfo;


public interface FRSDAO {

	public FRS findFrs(Integer id);

	public void saveFrs(FRSInfo studentInfo, Integer[] chooseMk);
	
	public void savePrs(FRSInfo studentInfo, Integer[] chooseMk);

	public FRSInfo findFrsInfo(Integer id);

	public void deleteFrs(Integer id);
	
	public List<Object[]> getListFrs();
	
	public void filterFrs(Integer id, FRSInfo frsInfo, Student student); 
	
	public void createFrs( Integer id,FRSInfo frsInfo, Student student);

}
