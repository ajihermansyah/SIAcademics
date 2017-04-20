package com.latihan.siacademic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.latihan.siacademic.dao.RoomDAO;
import com.latihan.siacademic.model.RoomInfo;

@Controller
@Transactional
@EnableWebMvc

public class RoomController {

	@Autowired
	private RoomDAO roomDAO;

	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public String roomList(Model model) {
		List<RoomInfo> list = roomDAO.listRoomInfos();
		model.addAttribute("roomInfos", list);
		return "roomList";
	}

	private String formRoom(Model model, RoomInfo roomInfo) {
		model.addAttribute("roomForm", roomInfo);
		if (roomInfo.getId() == null) {
			model.addAttribute("formTitle", "Create Room");
		} else {
			model.addAttribute("formTitle", "Edit Room");
		}
		return "formRoom";
	}

	@RequestMapping(value="/room", method=RequestMethod.GET)
	public String createRoom(Model model) {
		RoomInfo roomInfo = new RoomInfo();
		return this.formRoom(model, roomInfo);
	}

	@RequestMapping(value="/room/{id}/edit", method=RequestMethod.GET)
	public String editRoom(Model model, @PathVariable("id") Integer id) {
		RoomInfo roomInfo = null;
		roomInfo = this.roomDAO.findRoomInfo(id);
		return this.formRoom(model, roomInfo);
	}

	@RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
	public String deleteRoom(Model model, @PathVariable("id") Integer id) {
		this.roomDAO.deleteRoom(id);
		return "redirect:/rooms";
	}

	@RequestMapping(value = "/room", method = RequestMethod.POST)
	public String saveRoom(Model model, @ModelAttribute("roomForm") @Validated RoomInfo roomInfo) {
		this.roomDAO.saveRoom(roomInfo);
		return "redirect:/rooms";
	}
}
