package com.travelapplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.*;

import com.travelapplication.entity.*;


@Entity(name="Event")
@NamedQueries({
	@NamedQuery(name = "Event.findAll",query = "Select e from Event e"),
	@NamedQuery(name="Event.findByCategory",query="Select e from Event e where e.category_id=:categoryId"),
	@NamedQuery(name="Event.findByTitle",query="Select e from Event e where e.Event_name=:title"),
	@NamedQuery(name="Event.searchByKeyword",query="Select e from Event e where e.Event_Name=%||:keyword||%"
			+ " OR e.event_organizer=%||:keyword||% OR e.event_location=%||:keyword||%"),
	@NamedQuery(name="Event.findLatest",query="Select e from Event e order by e.event_publish_date desc")
	
})


public class Event {
	private Integer eventId;
	private String eventName;
	private String eventOrganizer;
	private String event_summary;
	private Date eventDate;
	private String eventDescription;
	private byte[] eventImage;
	private Date eventPublishDate;
	private Category category;
	private EventLocation location;
	
	private List<Review> reviews;
	private List<Event_Order> orders;
	
	
	
	
	
	
	
	@Id
	@Column(name="event_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "event_seq")
	@SequenceGenerator(name = "event_seq",sequenceName = "event_seq",allocationSize = 1)
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	@Column(name="event_name")
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	@Column(name="event_organizer")
	public String getEventOrganizer() {
		return eventOrganizer;
	}
	public void setEventOrganizer(String eventOrganizer) {
		this.eventOrganizer = eventOrganizer;
	}
	@Column(name="event_summary")
	public String getEvent_summary() {
		return event_summary;
	}
	public void setEvent_summary(String event_summary) {
		this.event_summary = event_summary;
	}
	@Column(name="event_date")
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	@Column(name="event_description")
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	@Column(name="event_image")
	public byte[] getEventImage() {
		return eventImage;
	}
	public void setEventImage(byte[] eventImage) {
		this.eventImage = eventImage;
	}
	@Column(name="event_publish_date")
	public Date getEventPublishDate() {
		return eventPublishDate;
	}
	
	public void setEventPublishDate(Date eventPublishDate) {
		this.eventPublishDate = eventPublishDate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="event_location_id")
	public EventLocation getLocation() {
		return location;
	}
	public void setLocation(EventLocation location) {
		this.location = location;
	}
	@OneToMany(targetEntity = Review.class,fetch = FetchType.LAZY)
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	@OneToMany(targetEntity = Event_Order.class,fetch = FetchType.LAZY)
	public List<Event_Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Event_Order> orders) {
		this.orders = orders;
	}
	
	}
