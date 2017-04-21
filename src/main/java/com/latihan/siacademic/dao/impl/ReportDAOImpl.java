package com.latihan.siacademic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.latihan.siacademic.dao.ReportDAO;
import com.latihan.siacademic.dao.SubMajorDAO;
import com.latihan.siacademic.entity.FRS;
import com.latihan.siacademic.entity.FRSDetails;
import com.latihan.siacademic.entity.SubMajor;

public class ReportDAOImpl implements ReportDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Object[]> reportMaxSubject(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubMajor.class, "sm");
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("majorId"))
				.add(Projections.count("subjectId"), "countSubject")).addOrder(Order.desc("countSubject"));
		criteria.setMaxResults(5);
		return criteria.list();
	}
	
	@Override
	public List<Object[]> reportTop3MaxSubject(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FRSDetails.class, "fd");
		criteria.createAlias("fd.frsId", "FRS");
		criteria.createAlias("FRS.student", "student");
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("sbjId"))
				.add(Projections.count("student.id"), "countStudent")).addOrder(Order.desc("countStudent"));
		criteria.setMaxResults(3);
		return criteria.list();
	}
	
	@Override
	public List<Object[]> reportMaxStudent(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FRSDetails.class, "fd");
		criteria.createAlias("fd.frsId", "FRS");
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("FRS.student"))
				.add(Projections.count("fd.sbjId"), "countSubject")).addOrder(Order.desc("countSubject"));
		criteria.setMaxResults(5);
		return criteria.list();
	}
	
	@Override
	public List<Object[]> reportSubject(Integer id){
		String sql = "select s.nim, s.studentName, f.semester "
				+ "from FRSDetails fd, FRS f, Student s, Subject sbj "
				+ "where s.id=f.student and fd.frsId = f.id and fd.sbjId = sbj.id and fd.sbjId="+id;
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		List<Object[]>listSbj=query.list();
		
		for(Object[] subject : listSbj){
			System.out.println("Nim  : "+subject[0]);
			System.out.println("Nama : "+subject[1]);
			System.out.println("SKS  : "+subject[2]);
		}
		return listSbj;
	}
	
	@Override
	public List<Object[]> reportMaxSks(String semester){
		String sql = "select s.nim, s.studentName, sum(sbj.sks),f.semester, f.id "
				+ "from Student s, Subject sbj, FRS f, FRSDetails fd "
				+ "where fd.frsId = f.id and fd.sbjId = sbj.id and f.student = s.id and f.semester = '"+semester+"' " 
				+ "Group by (s.nim, s.studentName,f.semester,f.id) "
				+ "Order by sum(sbj.sks) DESC ";
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		query.setMaxResults(2);
		List<Object[]>list1=query.list();
		
		for(Object[] maxSks : list1){
			System.out.println("Nim  : "+maxSks[0]);
			System.out.println("Nama : "+maxSks[1]);
			System.out.println("SKS  : "+maxSks[2]);
			System.out.println("semester : "+maxSks[3]);
			System.out.println("id   : "+maxSks[4]);
		}
		return list1;
	}
	
	@Override
	public List<Object[]> reportSchedule(String day, Integer in1, Integer in2){
		String sql = "select sbj.subjectCode, sbj.subjectName, r.roomName, s.jam_masuk, s.jam_keluar "
					+ "from Schedule s, Subject sbj, Room r "
					+ "where r.id=s.room and s.subj=sbj.id and (s.jam_masuk BETWEEN "+in1+" AND "+in2+") and s.days like '"+day+"'";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		List<Object[]> list = query.list();
		return list;
	}
	
}
