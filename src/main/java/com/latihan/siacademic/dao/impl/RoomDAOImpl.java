package com.latihan.siacademic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.latihan.siacademic.dao.RoomDAO;
import com.latihan.siacademic.entity.Room;
import com.latihan.siacademic.model.RoomInfo;

public class RoomDAOImpl implements RoomDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Room findRoom(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Room.class);
		criteria.add(Restrictions.eq("id", id));
		return (Room) criteria.uniqueResult();
	}
	
	@Override
	public RoomInfo findRoomInfo(Integer id){
		Room room = this.findRoom(id);
		if(room == null){
			return null;
		}
		return new RoomInfo(room.getId(), room.getRoomCode(), room.getRoomName());
	}
	
	@Override
	public void saveRoom(RoomInfo roomInfo) {
		Integer id = roomInfo.getId();
		Room room = null;
		if (id != null) {
			room = this.findRoom(id);
		}

		boolean isNew = false;
		if (room == null) {
			isNew = true;
			room = new Room();
		}
		room.setRoomCode(roomInfo.getRoomCode());
		room.setRoomName(roomInfo.getRoomName());

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(room);
		}
	}
	
	@Override
	public void deleteRoom(Integer id){
		Room room = this.findRoom(id);
		if(room != null){
			this.sessionFactory.getCurrentSession().delete(room);
		}
	}

	@Override
	public List<RoomInfo> listRoomInfos() {
		   String sql = "Select new " + RoomInfo.class.getName()//
	                + "(a.id, a.roomCode, a.roomName) "//
	                + " from " + Room.class.getName() + " a ";
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery(sql);
	        return query.list();
	}
	
	@Override
	public List<Room> listAllRoom(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Room.class);
		return criteria.list();
	}
}
