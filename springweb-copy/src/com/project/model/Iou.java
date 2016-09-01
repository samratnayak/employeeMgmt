package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="IOU")
public class Iou {

	@Id
	@Column(name="IOUID")
	@GeneratedValue(generator="iou_seq_gen")
	@SequenceGenerator(name="iou_seq_gen", sequenceName="IOU_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="IOUNAME")
	private String name;

	@Column(name="IOUHEAD")
	private String head;
	
	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
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
}
