package com.latihan.siacademic.dao;

import java.util.List;

import com.latihan.siacademic.entity.Subject;
import com.latihan.siacademic.model.SubjectInfo;

public interface SubjectDAO {

	public Subject findSubject(Integer id);
	
	public SubjectInfo findSubjectInfo(Integer id);
	
	public List<SubjectInfo> listSubjectInfos();
	
	public List<Subject> listAllSubject();
	
	public void saveSubject(SubjectInfo subjectInfo);
	
	public void deleteSubject(Integer id);
}
