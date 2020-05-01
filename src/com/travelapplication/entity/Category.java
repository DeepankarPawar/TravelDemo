package com.travelapplication.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity(name="Category")
@NamedQueries({
	@NamedQuery(name ="Categories.findAll",query = "Select c from Category c")
})
public class Category{	
private Integer categoryId;
	private String name;
	private List<Event> events;
	
	
	
	@Id
	@Column(name="category_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_seq")
	@SequenceGenerator(name="category_seq",sequenceName = "categ_seq",allocationSize = 1)
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
