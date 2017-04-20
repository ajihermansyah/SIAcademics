package com.latihan.siacademic.dao.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import com.latihan.siacademic.dao.FRSDAO;
import com.latihan.siacademic.dao.FRSDetailsDAO;
import com.latihan.siacademic.dao.MajorDAO;
import com.latihan.siacademic.dao.StudentDAO;
import com.latihan.siacademic.entity.FRS;
import com.latihan.siacademic.entity.Major;
import com.latihan.siacademic.entity.Student;
import com.latihan.siacademic.model.FRSInfo;

public class FRSDAOImpl implements FRSDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private FRSDetailsDAO frsDetailsDAO;

	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private MajorDAO majorDAO;

	@Override
	public FRS findFrs(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FRS.class);
		criteria.add(Restrictions.eq("id", id));
		return (FRS) criteria.uniqueResult();
	}

	@Override
	public FRSInfo findFrsInfo(Integer id) {
		FRS frs = this.findFrs(id);
		if (frs == null) {
			return null;
		}
		return new FRSInfo(frs.getId(), frs.getStudent().getId(), frs.getStudent().getNim(), frs.getStudent().getStudentName(), frs.getDosen_wali(), frs.getTgl_frs(), frs.getStatus(),frs.getSemester());
	}
	
	@Override
	public void filterFrs(Integer id, FRSInfo frsInfo, Student student) {
		if (id != null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate = LocalDate.now();

			frsInfo.setId(student.getId());
			frsInfo.setNim(student.getNim());
			frsInfo.setName(student.getStudentName());
			frsInfo.setTgl_frs(dtf.format(localDate));
		}
	}
	
	@Override 
	public void createFrs(Integer id, FRSInfo frsInfo, Student student){
		Major major = majorDAO.findMajor(student.getMajor().getId());

		if (id != null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate = LocalDate.now();

			frsInfo.setId(student.getId());
			frsInfo.setStudentId(frsInfo.getStudentId());
			frsInfo.setNim(student.getNim());
			frsInfo.setName(student.getStudentName());
			frsInfo.setDosen_wali(major.getHeadMajor());
			frsInfo.setTgl_frs(dtf.format(localDate));
			frsInfo.setStatus("Accepted");
			frsInfo.setSemester(frsInfo.getSemester());
		}
	}

	@Override
	public void saveFrs(FRSInfo frsInfo, Integer[] chooseMk) {
		Integer id = frsInfo.getId();
		boolean isNew = true;

		if (isNew) {
			Student student = studentDAO.findStudent(id);
			Session session2 = sessionFactory.getCurrentSession();
			FRS frs = new FRS();
			frs.setStudent(student);
			frs.setDosen_wali(frsInfo.getDosen_wali());
			frs.setTgl_frs(frsInfo.getTgl_frs());
			frs.setStatus("Accepted");
			frs.setSemester(frsInfo.getSemester());
			session2.persist(frs);
			frsDetailsDAO.saveFrsDetails(frs, chooseMk);
		}
	}
	
	@Override
	public void savePrs(FRSInfo frsInfo, Integer[] chooseMk) {
		Integer id = frsInfo.getId();
		boolean isNew = true;
		FRS frs = this.findFrs(id);
		if (isNew) {
			Student student = studentDAO.findStudent(frs.getStudent().getId());
			Session session2 = sessionFactory.getCurrentSession();
			
			frs.setStudent(student);
			frs.setDosen_wali(frsInfo.getDosen_wali());
			frs.setTgl_frs(frsInfo.getTgl_frs());
			frs.setStatus("Accepted");
			frs.setSemester(frsInfo.getSemester());
			session2.persist(frs);
			frsDetailsDAO.deleteFrsDetails(frs.getId());
			frsDetailsDAO.saveFrsDetails(frs, chooseMk);
		}
	}

	@Override
	public void deleteFrs(Integer id) {
		FRS frs = this.findFrs(id);
		if (frs != null) {
			frsDetailsDAO.deleteFrsDetails(frs.getId());
			this.sessionFactory.getCurrentSession().delete(frs);
		}
	}
	
	@Override
	public List<Object[]> getListFrs(){
		String sql = "select s.nim, s.studentName, f.tgl_frs,f.dosen_wali, "
					  + "sum(sbj.sks),f.semester,f.status, f.id "
					  + "from Student s, Subject sbj, FRS f, FRSDetails fd "
					  + "where fd.frsId = f.id and fd.sbjId = sbj.id and f.student = s.id "
					  + "Group by (s.nim, s.studentName,f.tgl_frs,f.dosen_wali,f.semester,f.status, f.id)";
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		List<Object[]>list1=query.list();
		
		for(Object[] frsf : list1){
			System.out.println("Nim  : "+frsf[0]);
			System.out.println("Nama : "+frsf[1]);
			System.out.println("SKS  : "+frsf[4]);
			System.out.println("ID   : "+frsf[7]);
		}
		return list1;
	}
}
