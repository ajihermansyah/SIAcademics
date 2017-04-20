package com.latihan.siacademic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.latihan.siacademic.dao.SubjectDAO;
import com.latihan.siacademic.entity.Subject;
import com.latihan.siacademic.model.SubjectInfo;

public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Subject findSubject(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Subject.class);
		criteria.add(Restrictions.eq("id", id));
		return (Subject) criteria.uniqueResult();
		
	}
	
	@Override
	public SubjectInfo findSubjectInfo(Integer id){
		Subject mk = this.findSubject(id);
		if(mk == null){
			return null;
		}
		return new SubjectInfo(mk.getId(), mk.getSubjectCode(), mk.getSubjectName(), mk.getSks(), mk.getSemester());
	}
	
	@Override
	public void saveSubject(SubjectInfo subjectInfo) {
		Integer id_mk = subjectInfo.getId();
		Subject mk = null;
		if (id_mk != null) {
			mk = this.findSubject(id_mk);
		}

		boolean isNew = false;
		if (mk == null) {
			isNew = true;
			mk = new Subject();
		}
		mk.setSubjectCode(subjectInfo.getSubjectCode());
		mk.setSubjectName(subjectInfo.getSubjectName());
		mk.setSks(subjectInfo.getSks());
		mk.setSemester(subjectInfo.getSemester());

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(mk);
		}
	}
	
	@Override
	public void deleteSubject(Integer id){
		Subject mk = this.findSubject(id);
		if(mk != null){
			this.sessionFactory.getCurrentSession().delete(mk);
		}
	}

	@Override
	public List<SubjectInfo> listSubjectInfos() {
		   String sql = "Select new " + SubjectInfo.class.getName()//
	                + "(a.id, a.subjectCode, a.subjectName, a.sks, a.semester) "//
	                + " from " + Subject.class.getName() + " a ";
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery(sql);
	        return query.list();
	}
	
	@Override
	public List<Subject> listAllSubject(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Subject.class);
		return criteria.list();
		
	}
}
