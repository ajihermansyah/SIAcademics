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
import com.latihan.siacademic.model.MajorInfo;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need To use RedirectAttributes
@EnableWebMvc

// update lagi
public class MajorController {

	@Autowired
	private MajorDAO majorDAO;

	@RequestMapping("/")
	public String homePage(Model model) {
		return majorList(model);
	}

	@RequestMapping(value = "/majors", method = RequestMethod.GET)
	public String majorList(Model model) {
		List<MajorInfo> list = majorDAO.listMajorInfos();
		model.addAttribute("majorInfos", list);
		return "majorList";
	}

	private String formMajor(Model model, MajorInfo majorInfo) {
		model.addAttribute("majorForm", majorInfo);

		if (majorInfo.getId() == null) {
			model.addAttribute("formTitle", "Create Major");
		} else {
			model.addAttribute("formTitle", "Edit Major");
		}
		return "formMajor";
	}

	@RequestMapping(value="/major", method=RequestMethod.GET)
	public String createMajor(Model model) {
		MajorInfo majorInfo = new MajorInfo();
		return this.formMajor(model, majorInfo);
	}

	@RequestMapping(value = "/major/{id}/edit", method = RequestMethod.GET)
	public String editMajor(Model model, @PathVariable("id") Integer id) {
		MajorInfo majorInfo = null;
		majorInfo = this.majorDAO.findMajorInfo(id);
		return this.formMajor(model, majorInfo);
	}

	@RequestMapping(value = "/major/{id}", method = RequestMethod.GET)
	public String deleteMajor(Model model, @PathVariable("id") Integer id) {
		this.majorDAO.deleteMajor(id);
		return "redirect:/majors";
	}

	@RequestMapping(value = "/major", method = RequestMethod.POST)
	public String saveMajor(Model model, @ModelAttribute("majorForm") @Validated MajorInfo majorInfo) {
		this.majorDAO.saveMajor(majorInfo);
		return "redirect:/majors";
	}
}
