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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.latihan.siacademic.dao.SubjectDAO;
import com.latihan.siacademic.model.SubjectInfo;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need To use RedirectAttributes
@EnableWebMvc

public class SubjectController {

	@Autowired
	private SubjectDAO subjectDAO;

	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public String subjectList(Model model) {
		List<SubjectInfo> list = subjectDAO.listSubjectInfos();
		model.addAttribute("subjectInfos", list);
		return "subjectList";
	}

	private String formSubject(Model model, SubjectInfo subjectInfo) {
		model.addAttribute("subjectForm", subjectInfo);

		if (subjectInfo.getId() == null) {
			model.addAttribute("formTitle", "Create Subject");
		} else {
			model.addAttribute("formTitle", "Edit Subject");
		}
		return "formSubject";
	}

	@RequestMapping(value="/subject", method=RequestMethod.GET)
	public String createSubject(Model model) {
		SubjectInfo subjectInfo = new SubjectInfo();
		return this.formSubject(model, subjectInfo);
	}

	@RequestMapping(value="subject/{id}/edit", method=RequestMethod.GET)
	public String editSubject(Model model, @PathVariable("id") Integer id) {
		SubjectInfo subjectInfo = null;
		subjectInfo = this.subjectDAO.findSubjectInfo(id);
		return this.formSubject(model, subjectInfo);
	}

	@RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
	public String deleteSubject(Model model, @PathVariable("id") Integer id) {
		this.subjectDAO.deleteSubject(id);
		return "redirect:/subjects";
	}

	@RequestMapping(value = "/subject", method = RequestMethod.POST)
	public String saveSubject(Model model, @ModelAttribute("subjectForm") @Validated SubjectInfo subjectInfo,
			@RequestParam ("numberSemester") Integer numberSemester) {
		System.out.println("number = "+numberSemester);
		if(numberSemester % 2 == 0){
			subjectInfo.setSemester("Genap");
		}else{
			subjectInfo.setSemester("Ganjil");
		}
		System.out.println("info semester = "+subjectInfo.getSemester());
		this.subjectDAO.saveSubject(subjectInfo);
		return "redirect:/subjects";	
	}
}
