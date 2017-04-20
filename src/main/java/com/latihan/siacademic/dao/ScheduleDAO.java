package com.latihan.siacademic.dao;

import java.util.List;

import com.latihan.siacademic.entity.Schedule;
import com.latihan.siacademic.model.ScheduleInfo;

public interface ScheduleDAO {
	
	public Schedule findSchedule(Integer id);

	public List<ScheduleInfo> listScheduleInfos();

	public void saveSchedule(ScheduleInfo studentInfo);

	public ScheduleInfo findScheduleInfo(Integer id);

	public void deleteSchedule(Integer id);
}
