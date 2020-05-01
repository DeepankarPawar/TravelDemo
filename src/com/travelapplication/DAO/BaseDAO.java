package com.travelapplication.DAO;

import java.util.*;


public interface BaseDAO<T> {

	public T create(T t);
	
	public T update(T t);
	
	public T get(Object id);
	
	public void delete(Object id);
	
	public List<T> getAll();
	
	public Long getCount();
	
	
	
	
	
	
	
	
	
}
