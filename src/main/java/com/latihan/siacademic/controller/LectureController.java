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

import com.latihan.siacademic.dao.MajorDAO;
import com.latihan.siacademic.dao.LectureDAO;
import com.latihan.siacademic.entity.Major;
import com.latihan.siacademic.enums.Position;
import com.latihan.siacademic.model.LectureInfo;

@Controller
@Transactional
@EnableWebMvc

public class LectureController {

	@Autowired
	private LectureDAO LectureDAO;

	@Autowired
	private MajorDAO majorDAO;

	@RequestMapping(value="/lectures", method=RequestMethod.GET)
	public String LectureList(Model model) {
		List<LectureInfo> list = LectureDAO.listLectureInfos();
		model.addAttribute("lectureInfos", list);
		return "lectureList";
	}

	private String formLecture(Model model, LectureInfo LectureInfo) {
		model.addAttribute("lectureForm", LectureInfo);
		List<Major> major = majorDAO.listAllMajor();
		
		model.addAttribute("posList",Position.values());
		model.addAttribute("major", major);

		if (LectureInfo.getId() == null) {
			model.addAttribute("formTitle", "Create Lecture");
		} else {
			model.addAttribute("formTitle", "Edit Lecture");
		}
		return "formLecture";
	}

	@RequestMapping(value="/lecture", method=RequestMethod.GET)
	public String createLecture(Model model) {
		LectureInfo lectureInfo = new LectureInfo();
		return this.formLecture(model, lectureInfo);
	}

	@RequestMapping(value = "/lecture/{id}/edit", method = RequestMethod.GET)
	public String editLecture(Model model, @PathVariable("id") Integer id) {
		LectureInfo lectureInfo = null;
		lectureInfo = this.LectureDAO.findLectureInfo(id);
		return this.formLecture(model, lectureInfo);
	}

	@RequestMapping(value = "/lecture/{id}", method = RequestMethod.GET)
	public String deleteLecture(Model model, @PathVariable("id") Integer id) {
		this.LectureDAO.deleteLecture(id);
		return "redirect:/lectures";
	}

	@RequestMapping(value = "/lecture", method = RequestMethod.POST)
	public String saveLecture(Model model, @ModelAttribute("lectureForm") @Validated LectureInfo lectureInfo) {
		this.LectureDAO.saveLecture(lectureInfo);
		return "redirect:/lectures";
	}
	
}
