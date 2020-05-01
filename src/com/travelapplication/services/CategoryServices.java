package com.travelapplication.services;

import java.util.List;

import com.travelapplication.DAO.CategoryDAO;
import com.travelapplication.entity.Category;



public class CategoryServices {

	private CategoryDAO categoryDao=null;
	
	public CategoryServices()
	{
		categoryDao=new CategoryDAO();
	}
	
	public List<Category> getAll(){ 
		
		return categoryDao.getAll();
		
	}
	
	public Category CreateCategory(Category c)
	{
		return categoryDao.create(c);
	}
	
	public Category updateCategory(Category c) {
		return categoryDao.update(c);
	}
	
	public void deleteCategory(Integer id) {
		categoryDao.delete(id);
		
	}
	
	
	
	
	
	
	
	
	
}
