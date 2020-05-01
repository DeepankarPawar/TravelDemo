package com.travelapplication.DAO;

import java.util.List;

import com.travelapplication.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements BaseDAO<Category> {

	@Override
	public Category create(Category t) {
		// TODO Auto-generated method stub
		return super.create(t);
	}

	@Override
	public Category update(Category t) {
		// TODO Auto-generated method stub
		return super.update(t);
	}

	@Override
	public Category get(Object id) {
		// TODO Auto-generated method stub
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		super.delete(Category.class,id );
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return super.getAll("Categories.findAll");
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
