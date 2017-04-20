package com.latihan.siacademic.controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Hibernate;
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
import com.latihan.siacademic.dao.FRSDAO;
import com.latihan.siacademic.dao.FRSDetailsDAO;
import com.latihan.siacademic.dao.SubMajorDAO;
import com.latihan.siacademic.dao.StudentDAO;
import com.latihan.siacademic.entity.FRS;
import com.latihan.siacademic.entity.FRSDetails;
import com.latihan.siacademic.entity.SubMajor;
import com.latihan.siacademic.entity.Student;
import com.latihan.siacademic.model.FRSInfo;

@Controller
@Transactional
@EnableWebMvc

public class FRSController {

	@Autowired
	private FRSDAO frsDAO;

	@Autowired
	private FRSDetailsDAO frsDetailsDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private SubMajorDAO subMajorDAO;

	@RequestMapping(value="/frstudies", method=RequestMethod.GET)
	public String frsList(Model model) {
		List<Object[]> list = frsDAO.getListFrs();
		model.addAttribute("frsInfos", list);
		return "frsList";
	}

	@RequestMapping(value="/frstudies/{id}/details", method=RequestMethod.GET)
	public String frsDetailList(Model model, @PathVariable("id") Integer id) {
		FRSInfo frs = frsDAO.findFrsInfo(id);
		model.addAttribute("frsInfos", frs);
		List<FRSDetails> list = frsDetailsDAO.listFrsDetails(id);
		for (FRSDetails frsDetail : list) {
			Hibernate.initialize(frsDetail.getSbjId().getSubjectName());
		}
		model.addAttribute("frsDetailInfos", list);
		return "frsDetails";
	}

	private String formFrsFilter(Model model, FRSInfo frsInfo, Student student) {
		model.addAttribute("frsFilterForm", frsInfo);
		model.addAttribute("formTitle", "Create Frs");
		return "formFRSFilter";
	}

	private String formFrs(Model model, FRSInfo frsInfo, Student student) {
		model.addAttribute("frsForm", frsInfo);
		
		List<SubMajor> listSubject = subMajorDAO.listSubMajor(student.getMajor().getId());
		for (SubMajor subMajor : listSubject) {
			Hibernate.initialize(subMajor.getSubjectId().getSubjectName());
		}

		List<SubMajor> subMajor = subMajorDAO.listSubMajorSemester(student.getMajor().getId(), frsInfo.getSemester());
		model.addAttribute("mk", subMajor);
		model.addAttribute("formTitle", "Create Frs");
		return "formFrs";
	}

	private String formPrs(Model model, FRSInfo frsInfo, Student student) {
		model.addAttribute("prsForm", frsInfo);
		model.addAttribute("formTitle", "Create PRS");

		Integer id = frsInfo.getId();
		List<FRSDetails> list = frsDetailsDAO.listFrsDetails(id);
		model.addAttribute("mk", list);
		for (FRSDetails frsDetail : list) {
			Hibernate.initialize(frsDetail.getSbjId().getSubjectName());
		}

		List<SubMajor> listSubMajor = subMajorDAO.getUniqueSubMajor(list, student.getMajor().getId(),frsInfo.getSemester());
		model.addAttribute("listUniqueSubject", listSubMajor);
		return "formEditFrs";
	}

	@RequestMapping(value="/frstudy/{id}/filter", method=RequestMethod.GET)
	public String createFrsFilter(Model model, @PathVariable("id") Integer id) {
		FRSInfo frsInfo = new FRSInfo();
		Student student = studentDAO.findStudent(id);
		
		if (student.getStatus().equals("Aktif")) {
			frsDAO.filterFrs(id, frsInfo, student);
			model.addAttribute("frsId",id);
			return this.formFrsFilter(model, frsInfo, student);
		} else {
			JOptionPane.showMessageDialog(null, "Maaf Anda tidak bisa melakukan FRS.\nStatus: Non Aktif/LULUS");
			return "redirect:/students";
		}
	}

	@RequestMapping(value="/frstudy/{id}/create", method=RequestMethod.GET)
	public String createFrs(Model model, @PathVariable("id") Integer id, @ModelAttribute("frsfilterForm") @Validated FRSInfo frsInfo) {
		Student student = studentDAO.findStudent(id);
		frsDAO.createFrs(id, frsInfo, student);
		return this.formFrs(model, frsInfo, student);
	}

	@RequestMapping(value="/frstudy/{id}/edit", method=RequestMethod.GET)
	public String editFrs(Model model, @PathVariable("id") Integer id) {
		FRSInfo frsInfo = null;
		FRS frs = null;
		Student std = null;

		frs = this.frsDAO.findFrs(id);
		frsInfo = this.frsDAO.findFrsInfo(id);
		std = studentDAO.findStudent(frs.getStudent().getId());
		return this.formPrs(model, frsInfo, std);
	}

	@RequestMapping(value="/frstudy/{id}", method=RequestMethod.GET)
	public String deleteFrs(Model model, @PathVariable("id") Integer id) {
		this.frsDAO.deleteFrs(id);
		return "redirect:/frstudies";
	}

	@RequestMapping(value = "/frstudy", method = RequestMethod.POST)
	public String saveFrs(Model model, @ModelAttribute("frsForm") @Validated FRSInfo frsInfo,
			@RequestParam("choose_mk") Integer[] chooseMk) {
		this.frsDAO.saveFrs(frsInfo, chooseMk);
		return "redirect:/frstudies";
	}

	@RequestMapping(value = "/prstudy", method = RequestMethod.POST)
	public String savePrs(Model model, @ModelAttribute("prsForm") @Validated FRSInfo frsInfo,
			@RequestParam("choose_mk") Integer[] chooseMk) {
		this.frsDAO.savePrs(frsInfo, chooseMk);
		return "redirect:/frstudies";
	}
}
