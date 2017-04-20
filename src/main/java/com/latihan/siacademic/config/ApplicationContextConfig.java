package com.latihan.siacademic.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.latihan.siacademic.dao.FRSDAO;
import com.latihan.siacademic.dao.FRSDetailsDAO;
import com.latihan.siacademic.dao.ScheduleDAO;
import com.latihan.siacademic.dao.MajorDAO;
import com.latihan.siacademic.dao.ReportDAO;
import com.latihan.siacademic.dao.SubjectDAO;
import com.latihan.siacademic.dao.SubMajorDAO;
import com.latihan.siacademic.dao.RoomDAO;
import com.latihan.siacademic.dao.StudentDAO;
import com.latihan.siacademic.dao.impl.FRSDAOImpl;
import com.latihan.siacademic.dao.impl.FRSDetailsDAOImpl;
import com.latihan.siacademic.dao.impl.ScheduleDAOImpl;
import com.latihan.siacademic.dao.impl.MajorDAOImpl;
import com.latihan.siacademic.dao.impl.ReportDAOImpl;
import com.latihan.siacademic.dao.impl.SubjectDAOImpl;
import com.latihan.siacademic.dao.impl.SubMajorDAOImpl;
import com.latihan.siacademic.dao.impl.RoomDAOImpl;
import com.latihan.siacademic.dao.impl.StudentDAOImpl;

@Configuration
@ComponentScan("com.latihan.siacademic.*")
@EnableTransactionManagement
@PropertySource("classpath:ds-hibernate-cfg.properties")

public class ApplicationContextConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name ="viewResolver")
	public InternalResourceViewResolver getViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean(name = "dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan(new String[] {"com.latihan.siacademic.entity"});
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		
		SessionFactory sf = factoryBean.getObject();
		return sf;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getHibertnateTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	
	 @Bean(name = "majorDAO")
	 public MajorDAO getMajorDAO() {
	     return new MajorDAOImpl();
	 }
	 
	 @Bean(name = "studentDAO")
	 public StudentDAO getStudentDAO() {
	     return new StudentDAOImpl();
	 }
	 
	 @Bean(name = "subjectDAO")
	 public SubjectDAO getSubjectDAO() {
	     return new SubjectDAOImpl();
	 }
	 
	 @Bean(name = "roomDAO")
	 public RoomDAO getRoomDAO() {
	     return new RoomDAOImpl();
	 }
	 
	 @Bean(name = "scheduleDAO")
	 public ScheduleDAO getScheduleDAO() {
	     return new ScheduleDAOImpl();
	 }
	 
	 @Bean(name = "subMajorDAO")
	 public SubMajorDAO getSubMajorDAO() {
	     return new SubMajorDAOImpl();
	 }
	 
	 @Bean(name = "frsDAO")
	 public FRSDAO getFrsDAO() {
	     return new FRSDAOImpl();
	 }
	 
	 @Bean(name = "frsDetailsDAO")
	 public FRSDetailsDAO getFrsDetailsDAO() {
	     return new FRSDetailsDAOImpl();
	 }
	 
	 @Bean(name = "reportDAO")
	 public ReportDAO getReport(){
		 return new ReportDAOImpl();
	 }

}
