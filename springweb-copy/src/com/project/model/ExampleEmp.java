package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MYEMP")
public class ExampleEmp {
	
		@Column(name="empid")
		@Id
		private int empId;
		
		@Column(name="empname")
		private String empName;
		
		@Column(name="iou")
		private int iou;
		
		public ExampleEmp(String name, int iou){
			this.empName = name;
			this.iou = iou;
		}
		public ExampleEmp(int id, String name, int iou) {
			// TODO Auto-generated constructor stub
			this.empId = id;
			this.empName = name;
			this.iou = iou;
		}
		public ExampleEmp() {
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

