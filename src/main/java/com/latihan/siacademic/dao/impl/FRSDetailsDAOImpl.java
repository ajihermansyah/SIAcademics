package com.latihan.siacademic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.latihan.siacademic.dao.FRSDetailsDAO;
import com.latihan.siacademic.dao.SubjectDAO;
import com.latihan.siacademic.entity.FRS;
import com.latihan.siacademic.entity.FRSDetails;
import com.latihan.siacademic.entity.Subject;
import com.latihan.siacademic.model.FRSDetailsInfo;

public class FRSDetailsDAOImpl implements FRSDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SubjectDAO subjectDAO;

	@Override
	public FRSDetails findFrsDetails(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FRSDetails.class);
		criteria.add(Restrictions.eq("id", id));
		return (FRSDetails) criteria.uniqueResult();

	}

	@Override
	public FRSDetails findIdFrs(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FRSDetails.class);
		criteria.add(Restrictions.eq("id", id));
		return (FRSDetails) criteria.uniqueResult();

	}

	@Override
	public FRSDetailsInfo findFrsDetailsInfo(Integer id) {
		FRSDetails frs = this.findFrsDetails(id);
		if (frs == null) {
			return null;
		}
		// return new FRSInfo(frs.getId(), frs.getStudent().getId(),
		// frs.getStudent().getNim(),
		// frs.getStudent().getStudentName(), frs.getDosen_wali(),
		// frs.getTgl_frs(), frs.getStatus());

		return new FRSDetailsInfo(frs.getId(), frs.getFrsId().getId(), frs.getSbjId().getId(),
				frs.getSbjId().getSubjectName(), frs.getSbjId().getSks());
	}

	@Override
	public void saveFrsDetails(FRS frsInfo, Integer[] chooseMk) {
		boolean isNew = true;
		
		
		if (isNew) {

			for (int i = 0; i < chooseMk.length; i++) {
				Session session = sessionFactory.getCurrentSession();
				FRSDetails frsDetails = new FRSDetails();
				Subject mk = subjectDAO.findSubject(chooseMk[i]);
				System.out.println("nama mk = " + mk.getSubjectName());
				System.out.println("id mk = " + mk.getId());
			
				frsDetails.setFrsId(frsInfo);
				frsDetails.setSbjId(mk);
				session.persist(frsDetails);
			}
		}
	}

	@Override
	public void deleteFrsDetails(Integer id) {
			String sql = "Delete from FRSDetails where frsId=" + id;
			Session session = sessionFactory.getCurrentSession();
			session.createQuery(sql).executeUpdate();
	}

	@Override
	public List<FRSDetailsInfo> listFrsDetailsInfos() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(FRSDetails.class, "fd");
		crit.createAlias("fd.frsId", "frs");
		crit.createAlias("fd.sbjId", "subject");
		return crit.list();
	}

	@Override
	public List<FRSDetails> listFrsDetails(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FRSDetails.class, "fd");
		criteria.add(Restrictions.eq("fd.frsId.id", id));
		return criteria.list();
	}
	
	@Override 
	public List<FRSDetailsInfo> getCountTotalSks(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FRSDetails.class,"frsDet");
		criteria.createAlias("frsDet.sbjId", "subject");
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("frsDet.frsId"))
				.add(Projections.sum("subject.sks"), "countSks"));
		
		return criteria.list();
	}

}
