package com.travelapplication.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name="Customer")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customer_id;
	private String name;
	private String address;
	private String city;
	private String country;
	private String pincode;
	private String password; 
	private Date registerDate;

	
	private List<Event_Order> eventOrders;
	private List<Review> reviews;
	
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cust_seq")
	@SequenceGenerator(sequenceName = "cust_seq",name="customer_seq",allocationSize = 1)
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	@Column(name="fullname")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	@OneToMany(targetEntity = Event_Order.class,fetch = FetchType.LAZY)
	public List<Event_Order> getEventOrders() {
		return eventOrders;
	}
	public void setEventOrders(List<Event_Order> eventOrders) {
		this.eventOrders = eventOrders;
	}
	@OneToMany(targetEntity = Review.class,fetch = FetchType.LAZY)
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="zipcode")
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="registerdate")
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	

	
	
	
	
	
	
	
}
