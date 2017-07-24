package com.shypz.shypzuser.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User_OTP",uniqueConstraints = {
		@UniqueConstraint(columnNames = "User_OTP_Id")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User_OTP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_OTP_Id")
	private long otpId;
	@Column(name="User_OTP",unique=false,nullable=false,length=45)
	private String userotp;
	//@org.hibernate.annotations.Type(t)
	@Column(name="User_Verification",unique=false,columnDefinition = "TINYINT(4) DEFAULT 0",nullable=false)
	private boolean userverification;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	
	public User_OTP() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User_OTP(long otpId, String userotp, boolean userverification, User user) {
		super();
		this.otpId = otpId;
		this.userotp = userotp;
		this.userverification = userverification;
		this.user = user;
	}


	public long getOtpId() {
		return otpId;
	}


	public void setOtpId(long otpId) {
		this.otpId = otpId;
	}


	public String getUserotp() {
		return userotp;
	}


	public void setUserotp(String userotp) {
		this.userotp = userotp;
	}


	public boolean isUserverification() {
		return userverification;
	}


	public void setUserverification(boolean userverification) {
		this.userverification = userverification;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	

}
