package com.latihan.siacademic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.latihan.siacademic.dao.MajorDAO;
import com.latihan.siacademic.entity.Major;
import com.latihan.siacademic.model.MajorInfo;


public class MajorDAOImpl implements MajorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Major findMajor(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Major.class);
		criteria.add(Restrictions.eq("id", id));
		return (Major) criteria.uniqueResult();
	}
	
	@Override
	public MajorInfo findMajorInfo(Integer id){
		Major major = this.findMajor(id);
		if(major == null){
			return null;
		}
		return new MajorInfo(major.getId(), major.getMajorCode(), major.getMajorName(), major.getFaculty(), major.getHeadMajor());
	}
	
	@Override
	public void saveMajor(MajorInfo majorInfo) {
		Integer id_major = majorInfo.getId();
		Major major = null;
		if (id_major != null) {
			major = this.findMajor(id_major);
		}

		boolean isNew = false;
		if (major == null) {
			isNew = true;
			major = new Major();
		}
		major.setMajorCode(majorInfo.getMajorCode());
		major.setMajorName(majorInfo.getMajorName());
		major.setFaculty(majorInfo.getFaculty());
		major.setHeadMajor(majorInfo.getHeadMajor());

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(major);
		}
	}
	
	@Override
	public void deleteMajor(Integer id){
		Major major = this.findMajor(id);
		if(major != null){
			this.sessionFactory.getCurrentSession().delete(major);
		}
	}

	@Override
	public List<MajorInfo> listMajorInfos() {
		   String sql = "Select new " + MajorInfo.class.getName()//
	                + "(a.id, a.majorCode, a.majorName, a.faculty, a.headMajor) "//
	                + " from " + Major.class.getName() + " a ";
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery(sql);
	        return query.list();
	}

	@Override
	public List<Major> listAllMajor(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Major.class);
		return criteria.list();
	}
}
