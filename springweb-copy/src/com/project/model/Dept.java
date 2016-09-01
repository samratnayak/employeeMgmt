package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Dept {
	@Column(name="ID")
	@GeneratedValue(generator="dept_seq_gen")
	@SequenceGenerator(name="dept_seq_gen", sequenceName="DEPT_SEQ", allocationSize=1)
	@Id
	private int id;
	
	@Column(name="DESCRIPTION")
	private String desc;
	
	public void setDept(int dept) {
		this.id = dept;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
