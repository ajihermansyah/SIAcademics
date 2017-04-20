package com.latihan.siacademic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.latihan.siacademic.dao.MajorDAO;
import com.latihan.siacademic.dao.SubjectDAO;
import com.latihan.siacademic.dao.SubMajorDAO;
import com.latihan.siacademic.entity.SubMajor;
import com.latihan.siacademic.entity.FRSDetails;
import com.latihan.siacademic.entity.Major;
import com.latihan.siacademic.entity.Subject;
import com.latihan.siacademic.model.SubMajorInfo;

public class SubMajorDAOImpl implements SubMajorDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired 
	private MajorDAO majorDAO;
	
	@Override
	public SubMajor findSubMajor(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubMajor.class);
		criteria.add(Restrictions.eq("id", id));
		return (SubMajor) criteria.uniqueResult();
	}
	
	@Override
	public SubMajorInfo findSubMajorInfo(Integer id){
		SubMajor subMajor = this.findSubMajor(id);
		if(subMajor == null){
			return null;
		}
		System.out.println("ooo= "+subMajor.getId());
		System.out.println("ssss="+subMajor.getSubjectId().getId());
		return new SubMajorInfo(subMajor.getId(), subMajor.getSubjectId().getId(), subMajor.getMajorId().getId());
	}
	
	@Override
	public void saveSubMajor(SubMajorInfo subMajorInfo) {
		Integer id = subMajorInfo.getId();
		Integer id_major = subMajorInfo.getMajorId();
		Integer id_subject = subMajorInfo.getSubjectId();
	
		SubMajor subMajor = null;
		Major major = new Major();
		Subject subject = new Subject();
		
		major= majorDAO.findMajor(id_major);
		subject = subjectDAO.findSubject(id_subject);

		System.out.println("id ="+subMajorInfo.getId());
		System.out.println("Major "+id_major);
		System.out.println("subject = "+id_subject);
		System.out.println("name = "+subject.getSubjectName());
		if (id == null) {
			System.out.println("kosong");
			subMajor = new SubMajor();
			
		} else {
			System.out.println("isi");
			subMajor = this.findSubMajor(id);
		}
		
		Session session = this.sessionFactory.getCurrentSession();
		subMajor.setSubjectId(subject);
		subMajor.setMajorId(major);
		session.persist(subMajor);
	}
	
	@Override
	public void deleteSubMajor(Integer id){
		SubMajor subMajor = this.findSubMajor(id);
		if(subMajor != null){
			this.sessionFactory.getCurrentSession().delete(subMajor);
		}
	}

	@Override
	public List<SubMajorInfo> listSubMajorInfos() {
		  
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(SubMajor.class, "subMajor");
		 crit.createAlias("subMajor.majorId", "major");
		 crit.createAlias("subMajor.subjectId", "subject");
		return  crit.list();
	}
	
	@Override
	public List<SubMajor> listSubMajor(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubMajor.class, "mk");
		criteria.add(Restrictions.eq("mk.majorId.id", id));
		return criteria.list();
	}
	
	@Override
	public List<SubMajor> listSubMajorSemester(Integer id, String semester){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubMajor.class, "m");
		criteria.createAlias("m.majorId", "major");
		criteria.createAlias("m.subjectId", "subject");
		criteria.add(Restrictions.eq("major.id", id));
		criteria.add(Restrictions.eq("subject.semester", semester));
		return criteria.list();
	}
	
	@Override
	public List<SubMajor> getUniqueSubMajor(List<FRSDetails> details, Integer id, String semester){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubMajor.class,"sm");
		criteria.createAlias("sm.majorId", "major");
		criteria.createAlias("sm.subjectId", "subject");
		criteria.add(Restrictions.eq("major.id", id));
		criteria.add(Restrictions.eq("subject.semester", semester));
		
		for(FRSDetails listFrsDetail :details){
			criteria.add(Restrictions.ne("subject.id", listFrsDetail.getSbjId().getId()));
		}
		
		return criteria.list();
	}
	
}
