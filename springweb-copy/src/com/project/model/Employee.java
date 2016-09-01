package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.project.validator.ValidEmail;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	@Column(name="ID")
	@GeneratedValue(generator="emp_seq_gen")
	@SequenceGenerator(name="emp_seq_gen", sequenceName="DEPT_SEQ", allocationSize=1)
	@Id
	private int id;
	
	@Column(name="EMPNAME")
	@Size(min=3,max=60, message="Name must be between 3 and 60 chars" )
	private String name;
	
	@Column(name="IOU")
	@NotNull(message="Select iou")
	private int iou;
	
	@Column(name="EMAIL")
	@NotNull
	//@Pattern(regexp="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message="Invalid  Email")
	@ValidEmail(min=6,message="InvalidEmail, min:6, max:60",max=60)
	private String email;

	public Employee(){}
	
	public Employee( String name, int iou, String email) {
		
		this.name = name;
		this.iou = iou;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIou() {
		return iou;
	}

	public void setIou(int iou) {
		this.iou = iou;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", iou=" + iou
				+ ", email=" + email + "]";
	}

}
