package com.latihan.siacademic.dao;

import java.util.List;

import com.latihan.siacademic.entity.FRSDetails;
import com.latihan.siacademic.entity.SubMajor;
import com.latihan.siacademic.model.SubMajorInfo;

public interface SubMajorDAO {

	public SubMajor findSubMajor(Integer id);

	public List<SubMajorInfo> listSubMajorInfos();
	
	public List<SubMajor> listSubMajor(Integer id);
	
	public List<SubMajor> listSubMajorSemester(Integer id, String semester);
	
	public List<SubMajor> getUniqueSubMajor(List<FRSDetails> details, Integer id, String semester);

	public void saveSubMajor(SubMajorInfo subMajorInfo);

	public SubMajorInfo findSubMajorInfo(Integer id);

	public void deleteSubMajor(Integer id);
}
