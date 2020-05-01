package com.travelapplication.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.travelapplication.entity.Users;

public class UserDAO extends JpaDAO<Users> implements BaseDAO<Users> {

	public UserDAO() {
	
		// TODO Auto-generated constructor stub
	}
  @Override public Users get(Object id) { // TODO Auto-generated method stub
	  return super.find(Users.class, id); }
	  
	  @Override public void delete(Object id) { // TODO Auto-generated method stub
	  super.delete(Users.class, id); }
	  
	  @Override public List<Users> getAll() { // TODO Auto-generated method stub
	  String Query="Users.findAll"; return super.getAll(Query); }
	  
	  @Override public Long getCount() { // TODO Auto-generated method stub return
	  return null; }
	  
	  @Override public Users update(Users u) {
		  return super.update(u);
	  }
	  

	  public Users findByEmail(String email) {
		  Map<String,String> Parameters=new HashMap<String,String>();
		  Parameters.put("email",email);
		 List<Users> user= super.getSingleData("Users.findByEmail",Parameters);
	  
	  if(user!=null && user.size()>1)
	  {
		  return user.get(0);
	  }
	  
	  return null;
	  }

	  public boolean checkLogin(String password,String email)
	  {
		  Map<String,String> Parameters=new HashMap<String,String>();
		  Parameters.put("email",email);
		  Parameters.put("password",password);
		  List<Users> user=super.getSingleData("Users.findLogin", Parameters);
		  if(user!=null && user.size()==1) {
			  return true;
		  }
		  else {
			  return false;
		  }
	  }  
		  
		  
	  
	  
	  public Users get(Integer id)
	  {
		  return super.find(Users.class, id);
	  
	  }
	  }





