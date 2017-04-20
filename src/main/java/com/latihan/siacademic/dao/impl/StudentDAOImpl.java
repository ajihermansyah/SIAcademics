package com.latihan.siacademic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.latihan.siacademic.dao.MajorDAO;
import com.latihan.siacademic.dao.StudentDAO;
import com.latihan.siacademic.entity.Major;
import com.latihan.siacademic.entity.Student;
import com.latihan.siacademic.model.StudentInfo;



public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MajorDAO majorDAO;
	
	@Override
	public Student findStudent(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("id", id));
		return (Student) criteria.uniqueResult();
	}
	
	@Override
	public StudentInfo findStudentInfo(Integer id){
		Student student = this.findStudent(id);
		if(student == null){
			return null;
		}
		return new StudentInfo(student.getId(), student.getNim(), student.getStudentName(), student.getTahun_angkatan(), student.getStatus(), student.getMajor().getId());
	}
	
	@Override
	public void saveStudent(StudentInfo studentInfo) {
		Integer id = studentInfo.getId();
		Integer id_major = studentInfo.getMajorId();
		Student student = null;
		Major major = majorDAO.findMajor(id_major);
		
		Session session = this.sessionFactory.getCurrentSession();
		major =majorDAO.findMajor(id_major);
		
		if (id != null) {
			student = this.findStudent(id);
			major = majorDAO.findMajor(id_major);
			if(studentInfo.getTahun_angkatan() != student.getTahun_angkatan() || major.getMajorCode()!=student.getMajor().getMajorCode()){
				student.setNim((major.getMajorCode()*10000000)+(studentInfo.getTahun_angkatan()*1000)+this.getStudentByMajor(studentInfo.getTahun_angkatan(),major.getMajorCode()).size()+1);
				student.setMajor(major);
			}
		}
		
		boolean isNew = false;
		if(student == null ){
			isNew = true;
			student = new Student();
		}
	
		student.setStudentName(studentInfo.getStudentName());
		student.setTahun_angkatan(studentInfo.getTahun_angkatan());
		student.setStatus(studentInfo.getStatus());
		
		if (isNew) {
			student.setMajor(major);
			student.setNim((major.getMajorCode()*10000000)+(studentInfo.getTahun_angkatan()*1000)+this.getStudentByMajor(studentInfo.getTahun_angkatan(),major.getMajorCode()).size()+1);
			session.persist(student);
		}
	}
	
	@Override
	public void deleteStudent(Integer id){
		Student student = this.findStudent(id);
		if(student != null){
			this.sessionFactory.getCurrentSession().delete(student);
		}
	}

	@Override
	public List<StudentInfo> listStudentInfos() {  
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Student.class, "student");
		crit.createAlias("student.major", "major");
		return  crit.list();
	}
	
	@Override
	public List<Student> getStudentByMajor(Integer angkatan, Integer code){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Student.class, "std");
		criteria.createAlias("std.major", "major");
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("std.major"))
				.add(Projections.count("std.id"), "countStudent"));
		criteria.add(Restrictions.eq("std.tahun_angkatan", angkatan));
		criteria.add(Restrictions.eq("major.majorCode", code));
		return criteria.list();
	}
	
	@Override
	public List<Student> searchingStudent(String input){
		String sql = "select * from Students where studentName = "+input;
	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		List<Student>list1=query.list();
	
		for(Student frsf : list1){
			System.out.println("Nim  : "+frsf.getNim());
			System.out.println("Nama : "+frsf.getStudentName());
		}
	  return list1;	
		
	}
}
