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
import com.latihan.siacademic.dao.StudentDAO;
import com.latihan.siacademic.entity.Major;
import com.latihan.siacademic.model.StudentInfo;

@Controller
@Transactional
@EnableWebMvc

public class StudentController {

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private MajorDAO majorDAO;

	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String studentList(Model model) {
		List<StudentInfo> list = studentDAO.listStudentInfos();
		model.addAttribute("studentInfos", list);
		return "studentList";
	}

	private String formStudent(Model model, StudentInfo studentInfo) {
		model.addAttribute("studentForm", studentInfo);
		List<Major> major = majorDAO.listAllMajor();
		model.addAttribute("major", major);

		if (studentInfo.getId() == null) {
			model.addAttribute("formTitle", "Create Student");
		} else {
			model.addAttribute("formTitle", "Edit Student");
		}
		return "formStudent";
	}

	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String createStudent(Model model) {
		StudentInfo studentInfo = new StudentInfo();
		return this.formStudent(model, studentInfo);
	}

	@RequestMapping(value = "/student/{id}/edit", method = RequestMethod.GET)
	public String editStudent(Model model, @PathVariable("id") Integer id) {
		StudentInfo studentInfo = null;
		studentInfo = this.studentDAO.findStudentInfo(id);
		return this.formStudent(model, studentInfo);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public String deleteStudent(Model model, @PathVariable("id") Integer id) {
		this.studentDAO.deleteStudent(id);
		return "redirect:/students";
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String saveMahasiswa(Model model, @ModelAttribute("studentForm") @Validated StudentInfo studentInfo) {
		this.studentDAO.saveStudent(studentInfo);
		return "redirect:/students";
	}

}