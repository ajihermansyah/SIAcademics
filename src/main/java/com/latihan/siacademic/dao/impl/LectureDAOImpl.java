package com.latihan.siacademic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.latihan.siacademic.dao.LectureDAO;
import com.latihan.siacademic.dao.MajorDAO;
import com.latihan.siacademic.dao.UserDAO;
import com.latihan.siacademic.entity.Lecture;
import com.latihan.siacademic.entity.Major;
import com.latihan.siacademic.enums.Position;
import com.latihan.siacademic.model.LectureInfo;


public class LectureDAOImpl implements LectureDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MajorDAO majorDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Lecture findLecture(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Lecture.class);
		criteria.add(Restrictions.eq("id", id));
		return (Lecture) criteria.uniqueResult();
	}
	
	@Override
	public LectureInfo findLectureInfo(Integer id){
		Lecture lecture = this.findLecture(id);
		if(lecture == null){
			return null;
		}
		return new LectureInfo(lecture.getId(), lecture.getNID(), lecture.getLectureName(), lecture.getMajor().getId(), lecture.getPosition());
	}
	
	@Override
	public void saveLecture(LectureInfo lectureInfo) {
		Integer id = lectureInfo.getId();
		Integer id_major = lectureInfo.getMajor();
		Lecture lecture = null;
		Major major = majorDAO.findMajor(id_major);
		
		Session session = this.sessionFactory.getCurrentSession();
		major =majorDAO.findMajor(id_major);
		
		// 1100001
		if (id != null) {
			lecture = this.findLecture(id);
			major = majorDAO.findMajor(id_major);
			if(lectureInfo.getPosition() != lecture.getPosition() || major.getMajorCode()!= lecture.getMajor().getMajorCode()){
				lecture.setNID((major.getMajorCode()*100000)+(lectureInfo.getPosition().ordinal()*100)+this.getLectureByMajor(lectureInfo.getPosition(),major.getMajorCode()).size()+1);
				lecture.setMajor(major);
			}
		}
		
		boolean isNew = false;
		if(lecture == null ){
			isNew = true;
			lecture = new Lecture();
		}
	
		lecture.setLectureName(lectureInfo.getLectureName());
		lecture.setPosition(lectureInfo.getPosition());
		
		if (isNew) {
			lecture.setMajor(major);
			lecture.setNID((major.getMajorCode()*100000)+(lectureInfo.getPosition().ordinal()*100)+this.getLectureByMajor(lectureInfo.getPosition(),major.getMajorCode()).size()+1);
			session.persist(lecture);
			userDAO.saveUser(lecture.getNID(),"Lecture");
		}
	}
	
	@Override
	public void deleteLecture(Integer id){
		Lecture Lecture = this.findLecture(id);
		if(Lecture != null){
			this.sessionFactory.getCurrentSession().delete(Lecture);
		}
	}

	@Override
	public List<LectureInfo> listLectureInfos() {  
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Lecture.class, "Lecture");
		crit.createAlias("Lecture.major", "major");
		return  crit.list();
	}
	
	@Override
	public List<Lecture> getLectureByMajor(Position position, Integer code){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Lecture.class, "l");
		criteria.createAlias("l.major", "major");
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("l.major"))
				.add(Projections.count("l.id"), "countLecture"));
		criteria.add(Restrictions.eq("l.position", position));
		criteria.add(Restrictions.eq("major.majorCode", code));
		return criteria.list();
	}
	
}
