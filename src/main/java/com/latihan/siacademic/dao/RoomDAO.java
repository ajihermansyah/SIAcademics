package com.latihan.siacademic.dao;

import java.util.List;

import com.latihan.siacademic.entity.Room;
import com.latihan.siacademic.model.RoomInfo;

public interface RoomDAO {

	public Room findRoom(Integer id);
	
	public RoomInfo findRoomInfo(Integer id);
	
	public List<RoomInfo> listRoomInfos();
	
	public List<Room> listAllRoom();
	
	public void saveRoom(RoomInfo ruanganInfo);
	
	public void deleteRoom(Integer id);
}
