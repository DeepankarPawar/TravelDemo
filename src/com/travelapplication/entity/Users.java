package com.travelapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity(name="Users")
@NamedQueries(
		{
		@NamedQuery(name="Users.findAll",query="select u from Users u"),
		@NamedQuery(name="Users.findByEmail",query="select u from Users u where u.email=:p"),
		
		@NamedQuery(name="Users.findLogin",query="Select u from Users u where u.email=:email and u.password=:password")
		
		})
public class Users {

	private Integer user_id;
	private String email;
	private String password;
	private String fullName;
	
	
	
	
	
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_sequence")
	@SequenceGenerator(name="user_sequence",sequenceName="user_seq",allocationSize =1)
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="FULL_NAME")
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
	
	
	
}
