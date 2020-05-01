package com.travelapplication.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.travelapplication.DAO.BaseDAO;
import com.travelapplication.DAO.JpaDAO;
import com.travelapplication.DAO.UserDAO;
import com.travelapplication.entity.Users;

public class UserServices {


	private UserDAO uDAO=null;
	
	public UserServices() {
		this.uDAO=new UserDAO();
	}
	public UserDAO getuDAO() {
		return uDAO;
	}
	public void setuDAO(UserDAO uDAO) {
		this.uDAO = uDAO;
	}

	public Users getUser(Integer Id)
	{
		return this.getuDAO().get(Id);
	}
	
	public Users getUsersByEmail(String email)
	{
		return getuDAO().findByEmail(email);
	}
	
	public boolean getUser(String user,String pwd)
	{
		return getuDAO().checkLogin(pwd, user);
	}
	
	public void createUser(Users user) {
		this.getuDAO().create(user);
	}
	public List<Users> getAll(){
		return this.getuDAO().getAll();
	}
	public void delete(Integer id)
	{
		this.getuDAO().delete(id);
	}
	
	public Users update(Users u) {
		return this.getuDAO().update(u);
		
	}
	
	}
	



	

