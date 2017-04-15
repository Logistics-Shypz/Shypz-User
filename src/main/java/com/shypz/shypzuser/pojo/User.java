package com.shypz.shypzuser.pojo;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="User",uniqueConstraints = {
		@UniqueConstraint(columnNames = "User_Id"),
		@UniqueConstraint(columnNames = "User_Name"),
		@UniqueConstraint(columnNames = "User_Email"),
		@UniqueConstraint(columnNames = "User_Mobile")})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long User_Id;
	@Column(name="User_Name",unique=true,nullable=false)
	private String username;
	@Column(name="User_Email",unique=true,nullable=false,length=255)
	private String User_Email;
	@Column(name="User_Password",unique=false,nullable=false,length=255)
	private String User_Password;
	@Column(name="User_Mobile",unique=true,nullable=false,length=10)
	private String User_Mobile;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public User(long user_Id, String username, String user_Email, String user_Password, String user_Mobile) {
		super();
		User_Id = user_Id;
		this.username = username;
		User_Email = user_Email;
		User_Password = user_Password;
		User_Mobile = user_Mobile;
	}
	
	
	
	public long getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(long user_Id) {
		User_Id = user_Id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_Email() {
		return User_Email;
	}
	public void setUser_Email(String user_Email) {
		User_Email = user_Email;
	}
	public String getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}
	public String getUser_Mobile() {
		return User_Mobile;
	}
	public void setUser_Mobile(String user_Mobile) {
		User_Mobile = user_Mobile;
	}
	
	
	

}
