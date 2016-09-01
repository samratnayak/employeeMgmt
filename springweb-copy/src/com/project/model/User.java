package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.project.validator.ValidEmail;

@Table(name="USERS")
@Entity
public class User {
	
	
	@Column( name= "USERID")
	@SequenceGenerator(sequenceName="USER_SEQ", initialValue=1,allocationSize=1, name = "user_seq_gen")
	@GeneratedValue(generator="user_seq_gen")
	private int userid;
	
	@Id
	@Column	
	@NotNull(message="Username must not be blank")
	@Size( min=3, max=20, message="Username must be between 3 and 20")
	private String username;
	
	@NotBlank( message= "Password cant be blank")
	@Size( min=5,  message="Password must be between 5 and 20")
	@Column(name="USERPASS")
	private String password;
	
	@Column(name="ENABLED")
	private boolean isEnabled = true;
	
	@ValidEmail
	@Column
	private String email;
	
	@Column
	private String authority;
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getUserid() {
		return userid;
	}
	
	public User(){}
	

	public User(String username, String password, boolean isEnabled, String email) {
		this.username = username;
		this.password = password;
		this.isEnabled = isEnabled;
		this.email = email;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
