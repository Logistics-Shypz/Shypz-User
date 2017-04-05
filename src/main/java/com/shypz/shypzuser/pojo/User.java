package com.shypz.shypzuser.pojo;

public class User {
	
	private int User_Id;
	private String User_Name;
	private String User_Email;
	private String User_Password;
	private String User_Mobile;
	
	
	public User(){
		
	}
	
	public User(int user_Id, String user_Name, String user_Email, String user_Password, String user_Mobile) {
		super();
		User_Id = user_Id;
		User_Name = user_Name;
		User_Email = user_Email;
		User_Password = user_Password;
		User_Mobile = user_Mobile;
	}



	public int getUser_Id() {
		return User_Id;
	}



	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}



	public String getUser_Name() {
		return User_Name;
	}



	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
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
