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
import com.latihan.siacademic.dao.SubMajorDAO;
import com.latihan.siacademic.dao.MajorDAO;
import com.latihan.siacademic.dao.SubjectDAO;
import com.latihan.siacademic.entity.Major;
import com.latihan.siacademic.entity.Subject;
import com.latihan.siacademic.model.SubMajorInfo;

@Controller
@Transactional
@EnableWebMvc

public class SubMajorController {

	@Autowired
	private SubMajorDAO mkJurDAO;

	@Autowired
	private MajorDAO majorDAO;

	@Autowired
	private SubjectDAO subjectDAO;

	@RequestMapping(value="/subMajors", method=RequestMethod.GET)
	public String mkJurList(Model model) {
		List<SubMajorInfo> list = mkJurDAO.listSubMajorInfos();
		model.addAttribute("subMajorInfos", list);
		return "subMajorList";
	}

	private String formSubMajor(Model model, SubMajorInfo subMajorInfo) {
		model.addAttribute("subMajorForm", subMajorInfo);
		List<Major> major = majorDAO.listAllMajor();
		model.addAttribute("major", major);

		List<Subject> subject = subjectDAO.listAllSubject();
		model.addAttribute("mk", subject);

		if (subMajorInfo.getId() == null) {
			model.addAttribute("formTitle", "Create SubMajor");
		} else {
			model.addAttribute("formTitle", "Edit SubMajor");
		}
		return "formSubMajor";
	}

	@RequestMapping(value="/subMajor",method=RequestMethod.GET)
	public String createSubMajor(Model model) {
		SubMajorInfo mkJurInfo = new SubMajorInfo();
		return this.formSubMajor(model, mkJurInfo);
	}

	@RequestMapping(value="/subMajor/{id}/edit", method=RequestMethod.GET)
	public String editSubMajor(Model model, @PathVariable("id") Integer id) {
		SubMajorInfo mkJurInfo = null;
		mkJurInfo = this.mkJurDAO.findSubMajorInfo(id);
		return this.formSubMajor(model, mkJurInfo);
	}

	@RequestMapping(value = "/subMajor/{id}", method = RequestMethod.GET)
	public String deleteSubMajor(Model model, @PathVariable("id") Integer id) {
		this.mkJurDAO.deleteSubMajor(id);
		return "redirect:/subMajors";
	}

	@RequestMapping(value = "/subMajor", method = RequestMethod.POST)
	public String saveSubMajor(Model model, @ModelAttribute("subMajorForm") @Validated SubMajorInfo subMajorInfo) {
		this.mkJurDAO.saveSubMajor(subMajorInfo);
		return "redirect:/subMajors";
	}
}
