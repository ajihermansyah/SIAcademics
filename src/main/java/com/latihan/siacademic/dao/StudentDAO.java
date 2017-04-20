package com.latihan.siacademic.dao;

import java.util.List;

import com.latihan.siacademic.entity.Student;
import com.latihan.siacademic.model.StudentInfo;

public interface StudentDAO {

	public Student findStudent(Integer id);
	
	public List<StudentInfo> listStudentInfos();
	
	public void saveStudent(StudentInfo studentInfo);
	
	public StudentInfo findStudentInfo(Integer id);
	
	public void deleteStudent(Integer id);	
	
	public List<Student> getStudentByMajor(Integer angkatan, Integer code);
	
	public List<Student> searchingStudent(String input);
}
