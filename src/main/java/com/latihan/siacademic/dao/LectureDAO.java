package com.latihan.siacademic.dao;

import java.util.List;

import com.latihan.siacademic.entity.Lecture;
import com.latihan.siacademic.enums.Position;
import com.latihan.siacademic.model.LectureInfo;

public interface LectureDAO {

	public Lecture findLecture(Integer id);
	
	public List<LectureInfo> listLectureInfos();
	
	public void saveLecture(LectureInfo lectureInfo);
	
	public LectureInfo findLectureInfo(Integer id);
	
	public void deleteLecture(Integer id);	
	
	public List<Lecture> getLectureByMajor(Position position, Integer code);
	
}
