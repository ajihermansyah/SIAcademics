package com.latihan.siacademic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.latihan.siacademic.dao.ScheduleDAO;
import com.latihan.siacademic.dao.SubjectDAO;
import com.latihan.siacademic.dao.RoomDAO;
import com.latihan.siacademic.entity.Subject;
import com.latihan.siacademic.entity.Room;
import com.latihan.siacademic.entity.Schedule;
import com.latihan.siacademic.model.ScheduleInfo;

public class ScheduleDAOImpl implements ScheduleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired 
	private RoomDAO roomDAO;
	
	@Override
	public Schedule findSchedule(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Schedule.class);
		criteria.add(Restrictions.eq("id", id));
		return (Schedule) criteria.uniqueResult();
	}
	
	@Override
	public ScheduleInfo findScheduleInfo(Integer id){
		Schedule schedule = this.findSchedule(id);
		if(schedule == null){
			return null;
		}
		System.out.println("aaaa= "+schedule.getId());
		System.out.println("bbbb="+schedule.getSubj().getId());
		return new ScheduleInfo(schedule.getId(), schedule.getSubj().getId(), schedule.getRoom().getId(), schedule.getJam_masuk(), schedule.getJam_keluar(), schedule.getDays());
	}
	
	@Override
	public void saveSchedule(ScheduleInfo scheduleInfo) {
		Integer id = scheduleInfo.getId();
		Integer id_room = scheduleInfo.getRoom();
		Integer id_mk = scheduleInfo.getSubj();
		Schedule schedule = null;
		Room room = new Room();
		Subject subject = new Subject();
		room = roomDAO.findRoom(id_room);
		subject = subjectDAO.findSubject(id_mk);

		System.out.println("id ="+id);
		System.out.println("b2 = "+id_mk);
		if (id == null) {
			System.out.println("kosongs");
			schedule = new Schedule();
		} else {
			System.out.println("isis");
			schedule = this.findSchedule(id);
		}

		Session session = this.sessionFactory.getCurrentSession();
	
		schedule.setSubj(subject);
		schedule.setRoom(room);
		schedule.setJam_masuk(scheduleInfo.getJam_masuk());
		schedule.setJam_keluar(scheduleInfo.getJam_keluar());
		schedule.setDays(scheduleInfo.getDays());
		session.persist(schedule);
	}
	
	@Override
	public void deleteSchedule(Integer id){
		Schedule schedule = this.findSchedule(id);
		if(schedule != null){
			this.sessionFactory.getCurrentSession().delete(schedule);
		}
	}

	@Override
	public List<ScheduleInfo> listScheduleInfos() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Schedule.class, "schedule");
		crit.createAlias("schedule.room", "room");
		crit.createAlias("schedule.subj", "subject");
		return  crit.list();
	}
	
}
