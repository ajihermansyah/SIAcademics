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
import com.latihan.siacademic.dao.SubjectDAO;
import com.latihan.siacademic.dao.RoomDAO;
import com.latihan.siacademic.dao.ScheduleDAO;
import com.latihan.siacademic.entity.Subject;
import com.latihan.siacademic.entity.Room;
import com.latihan.siacademic.model.ScheduleInfo;

@Controller
@Transactional
@EnableWebMvc

public class ScheduleController {

	@Autowired
	private ScheduleDAO scheduleDAO;

	@Autowired
	private RoomDAO roomDAO;

	@Autowired
	private SubjectDAO mataKuliahDAO;

	@RequestMapping(value = "/schedules", method = RequestMethod.GET)
	public String scheduleList(Model model) {
		List<ScheduleInfo> list = scheduleDAO.listScheduleInfos();
		model.addAttribute("scheduleInfos", list);
		return "scheduleList";
	}

	private String formSchedule(Model model, ScheduleInfo scheduleInfo) {
		model.addAttribute("scheduleForm", scheduleInfo);
		List<Room> room = roomDAO.listAllRoom();
		model.addAttribute("room", room);

		List<Subject> mataKuliah = mataKuliahDAO.listAllSubject();
		model.addAttribute("mk", mataKuliah);

		if (scheduleInfo.getId() == null) {
			model.addAttribute("formTitle", "Create Schedule");
		} else {
			model.addAttribute("formTitle", "Edit Schedule");
		}
		return "formSchedule";
	}

	@RequestMapping(value="/schedule", method=RequestMethod.GET)
	public String createSchedule(Model model) {
		ScheduleInfo scheduleInfo = new ScheduleInfo();
		return this.formSchedule(model, scheduleInfo);
	}

	@RequestMapping(value="/schedule/{id}/edit", method=RequestMethod.GET)
	public String editSchedule(Model model, @PathVariable("id") Integer id) {
		ScheduleInfo scheduleInfo = null;
		scheduleInfo = this.scheduleDAO.findScheduleInfo(id);
		return this.formSchedule(model, scheduleInfo);
	}

	@RequestMapping(value = "/schedule/{id}", method = RequestMethod.GET)
	public String deleteSchedule(Model model, @PathVariable("id") Integer id) {
		this.scheduleDAO.deleteSchedule(id);
		return "redirect:/schedules";
	}

	@RequestMapping(value = "/schedule", method = RequestMethod.POST)
	public String saveSchedule(Model model, @ModelAttribute("scheduleForm") @Validated ScheduleInfo scheduleInfo) {
		this.scheduleDAO.saveSchedule(scheduleInfo);
		return "redirect:/schedules";
	}
}
