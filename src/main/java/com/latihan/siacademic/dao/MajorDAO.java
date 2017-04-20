package com.latihan.siacademic.dao;

import java.util.List;

import com.latihan.siacademic.entity.Major;
import com.latihan.siacademic.model.MajorInfo;

public interface MajorDAO {

	public Major findMajor(Integer id);
	
	public MajorInfo findMajorInfo(Integer id);
	
	public List<MajorInfo> listMajorInfos();
	
	public List<Major> listAllMajor();
	
	public void saveMajor(MajorInfo majorInfo);
	
	public void deleteMajor(Integer id);
	
}
