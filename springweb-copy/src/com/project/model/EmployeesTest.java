package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class EmployeesTest {

	@Column(name="ID")
	@Id
	private int empId;
	private String empName;
	private int iou;
	
	public EmployeesTest(String name, int iou){
		this.empName = name;
		this.iou = iou;
	}
	public EmployeesTest(int id, String name, int iou) {
		// TODO Auto-generated constructor stub
		this.empId = id;
		this.empName = name;
		this.iou = iou;
	}
	public EmployeesTest() {
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getIou() {
		return iou;
	}
	public void setIou(int iou) {
		this.iou = iou;
	}
	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", empName=" + empName + ", iou="
				+ iou + "]";
	}
	
}
