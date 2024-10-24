package com.fa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth")
public class Authent {
	@Id
	@Column(name = "user_name")
	private String userName;

	@Column(name = "pass_world")
	private String passWorld;

	public Authent() {
		super();
	}

	public Authent(String userName, String passWorld) {
		super();
		this.userName = userName;
		this.passWorld = passWorld;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWorld() {
		return passWorld;
	}

	public void setPassWorld(String passWorld) {
		this.passWorld = passWorld;
	}

}
