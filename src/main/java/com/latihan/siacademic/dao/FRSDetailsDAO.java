package com.latihan.siacademic.dao;

import java.util.List;

import com.latihan.siacademic.entity.FRS;
import com.latihan.siacademic.entity.FRSDetails;
import com.latihan.siacademic.model.FRSDetailsInfo;

public interface FRSDetailsDAO {

	public FRSDetails findFrsDetails(Integer id);
	
	public FRSDetails findIdFrs(Integer id);

	public List<FRSDetailsInfo> listFrsDetailsInfos();
	
    public List<FRSDetails> listFrsDetails(Integer id);

	public void saveFrsDetails(FRS frsDetailsInfo, Integer[] chooseMk);

	public FRSDetailsInfo findFrsDetailsInfo(Integer id);

	public void deleteFrsDetails(Integer id);
	
	public List<FRSDetailsInfo> getCountTotalSks();
	
	
}

