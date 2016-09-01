package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ForeignKey;
@Entity
@Table(name="MESSAGE")
public class Message {
	
	@Column(name="MSG_ID")
	@GeneratedValue(generator="msg_seq_gen")
	@SequenceGenerator(name="msg_seq_gen", sequenceName="MSG_SEQ", allocationSize=1)
	@Id
	private int id;
	
	@Column(name="TITLE")
	@Size(min=3,max=100)
	private String title;
	
	@Column(name="MESSAGE")
	@Size(min=4,max=500, message="Max 500")
	private String msg;
	
	//@Column(name="MSG_FROM")
	@JoinColumn(name="MSG_FROM")
	@ManyToOne//(fetch=FetchType.EAGER)
	private User msg_from;
	//@Pattern(regexp="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message="Invalid  Email")
	
	//@JoinColumn(name="USERID")
	

	public Message(){msg_from = new User();}
	
	public Message( String name, String msg, User userid) {
		
		this.title = name;
		this.msg = msg;
		this.msg_from = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public User getFromUser() {
		return msg_from;
	}

	public void setFromUser(User userid) {
		this.msg_from = userid;
	}

	

}
