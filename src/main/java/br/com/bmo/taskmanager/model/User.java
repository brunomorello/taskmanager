package br.com.bmo.taskmanager.model;

import java.time.LocalDateTime;

public class User {

	private String firstName;
	private String lastName;
	private String login;
	private String pwd;
	private LocalDateTime createdAt;
	private LocalDateTime lastLogin;
	
	public User(String firstName, String login, String pwd) {
		this.firstName = firstName;
		this.login = login;
		this.pwd = pwd;
	}
	
	public User() {
		
	}
	
	public boolean canLogin(String login, String pwd) {
		
		if (!this.login.equals(login))
			return false;
		
		if (!this.pwd.equals(pwd))
			return false;
		
		return true;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	
}
