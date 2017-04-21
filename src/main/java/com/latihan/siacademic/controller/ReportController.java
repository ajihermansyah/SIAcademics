package com.latihan.siacademic.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.latihan.siacademic.dao.ReportDAO;
import com.latihan.siacademic.dao.SubjectDAO;
import com.latihan.siacademic.entity.Subject;

@Controller
@Transactional
@EnableWebMvc
public class ReportController {

	@Autowired
	private ReportDAO reportDAO;
	
	@Autowired
	private SubjectDAO matakuliahDAO;

	@RequestMapping(value = "/majorReports", method = RequestMethod.GET)
	public String reportMaxSubject(Model model) {
		List<Object[]> listMaxSubject = reportDAO.reportMaxSubject();
		for (Object[] subMajor : listMaxSubject) {
			Hibernate.initialize(subMajor[0]);
		}
		model.addAttribute("reportMaxSubject", listMaxSubject);
		return "reportMaxSubject";
	}

	@RequestMapping(value = "/subjectReports", method = RequestMethod.GET)
	public String reportTop3MaxSubject(Model model) {
		List<Object[]> list = reportDAO.reportTop3MaxSubject();
		for (Object[] frs : list) {
			Hibernate.initialize(frs[0]);
		}
		model.addAttribute("reportTop3MaxSubjects", list);
		return "reportTop3MaxSubject";
	}

	@RequestMapping(value = "/studentReports", method = RequestMethod.GET)
	public String reportMaxStudents(Model model) {
		List<Object[]> list = reportDAO.reportMaxStudent();
		for (Object[] frs : list) {
			Hibernate.initialize(frs[0]);
		}
		model.addAttribute("reportMaxStudents", list);
		return "reportMaxStudent";
	}
	
	@RequestMapping(value = "/reports2", method = RequestMethod.GET)
	public String reporSubjects(Model model,@RequestParam("choose") Integer id) {
		List<Subject> mataKuliah = matakuliahDAO.listAllSubject();
		model.addAttribute("mk", mataKuliah);
		model.addAttribute("sbjId",id);
		List<Object[]> list = reportDAO.reportSubject(id);
		for (Object[] frs : list) {
			Hibernate.initialize(frs[0]);
		}
		model.addAttribute("reports2", list);
		return "reports2";
	}
	
	@RequestMapping(value = "/reportMaxSks", method = RequestMethod.GET)
	public String reportMaxSks(Model model, @RequestParam("choose") String semester) {
		List<Object[]> list = reportDAO.reportMaxSks(semester);
		for (Object[] frs : list) {
			Hibernate.initialize(frs[0]);
		}
		model.addAttribute("reportMaxSks", list);
		return "reportMaxSks";
	}
	
	@RequestMapping(value = "/reportSchedule", method = RequestMethod.GET)
	public String reportScedule(Model model, @RequestParam("days") String days, @RequestParam("in1") Integer in1, 
			@RequestParam("in2") Integer in2) {
		List<Object[]> list = reportDAO.reportSchedule(days, in1, in2);
		for (Object[] frs : list) {
			Hibernate.initialize(frs[0]);
		}
		model.addAttribute("reportSchedule", list);
		return "reportSchedule";
	}

}
