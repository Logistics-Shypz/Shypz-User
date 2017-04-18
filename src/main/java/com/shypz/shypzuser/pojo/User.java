package com.shypz.shypzuser.pojo;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User",uniqueConstraints = {
		@UniqueConstraint(columnNames = "User_Id"),
		@UniqueConstraint(columnNames = "User_Name"),
		@UniqueConstraint(columnNames = "User_Email"),
		@UniqueConstraint(columnNames = "User_Mobile")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_Id")
	private long uId;
	@Column(name="User_Name",unique=true,nullable=false)
	private String username;
	@Column(name="User_Email",unique=true,nullable=false,length=255)
	private String User_Email;
	@Column(name="User_Password",unique=false,nullable=false,length=255)
	private String User_Password;
	@Column(name="User_Mobile",unique=true,nullable=false,length=10)
	private String User_Mobile;
	@OneToMany
	private List<Address> address;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public User(long user_Id, String username, String user_Email, String user_Password, String user_Mobile) {
		super();
		this.uId = user_Id;
		this.username = username;
		User_Email = user_Email;
		User_Password = user_Password;
		User_Mobile = user_Mobile;
	}
	
	
	
	
	public User(long uId, String username, String user_Email, String user_Password, String user_Mobile,
			List<Address> address) {
		super();
		this.uId = uId;
		this.username = username;
		User_Email = user_Email;
		User_Password = user_Password;
		User_Mobile = user_Mobile;
		this.address = address;
	}



	public long getId() {
		return uId;
	}
	public void setId(long user_Id) {
		this.uId = user_Id;
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
	
	public List<Address> getAddress() {
		return address;
	}



	public void setAddress(List<Address> address) {
		this.address = address;
	}



	
	

}
