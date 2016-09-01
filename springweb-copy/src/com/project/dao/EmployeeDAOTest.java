package com.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.EmployeesTest;

@Component("employeeDao")
public class EmployeeDAOTest {

	private NamedParameterJdbcTemplate jdbc;
	
	public EmployeeDAOTest() {
		// TODO Auto-generated constructor stub
		System.out.println("Successfully Loaded DAO");
	}
	//@Autowired
	private SessionFactory sessionFac;
	
	private Session session;
	private Transaction t;
	
	
	/*@Autowired
	public void setSession(SessionFactory sessionFac) {
		this.sessionFac = sessionFac;
	}*/

	@Autowired
	public void setJdbc(DataSource d) {
		this.jdbc = new NamedParameterJdbcTemplate(d);
	}
	
	public List<EmployeesTest> getEmployee(){
		
		return jdbc.query("select * from myemp ", new RowMapper<EmployeesTest>(){
			public EmployeesTest mapRow(ResultSet rs, int rowNum){
				EmployeesTest e = new EmployeesTest();
				
				try {
					e.setEmpId(rs.getInt("empid"));
					e.setEmpName(rs.getString("empname"));
					e.setIou(rs.getInt("iou"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				return e;
				
			}
		});
		
	}
	
public List<Employees> getEmployeeUsingHQL(){
		
		session = SessionProvider.getSession();
		t = session.beginTransaction(); 		
				return session.createQuery("from Employees").list();
				
			
		
		
	}
	
	public boolean delete(int empid ){
		boolean isdeleted = false;
		int i=0;
		MapSqlParameterSource ps = new MapSqlParameterSource("id", empid);
		i=jdbc.update("delete from myemp where empid=:id",ps);
		isdeleted = i==0?false:true;
		return isdeleted;
	}
	
	public boolean createEmp(Employees e){
		BeanPropertySqlParameterSource param =  new BeanPropertySqlParameterSource(e);
		
	return jdbc.update("insert into myemp values(:empId,:empName,:iou)", param)==1;	
	}
	@Transactional
	public int[] createEmp(List<Employees> e){
		/*int i=0;
		BeanPropertySqlParameterSource[] param = new BeanPropertySqlParameterSource[e.size()];
		for(Employees e1: e){
			param[i++]=new BeanPropertySqlParameterSource(e1);
		}*/
		
		SqlParameterSource[] param = SqlParameterSourceUtils.createBatch( e.toArray());
		
		return jdbc.batchUpdate("insert into myemp values(:empId,:empName,:iou)", param);
	//return jdbc.batchUpdate("insert into myemp values(:empId,:empName,:iou)", e);	
	}
}
