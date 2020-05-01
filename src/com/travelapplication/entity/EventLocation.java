package com.travelapplication.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name="event_location")
public class EventLocation {

	private Integer locationId;
	private String locationName;
	private String locationState;
	private String locationCountry;
	private String locationCity;
	
	private List<Event> events;
	
	
	@Id
	@Column(name="event_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "location_seq")
	@SequenceGenerator(name = "location_seq",sequenceName = "location_seq",allocationSize = 1)
	
	public Integer getLocationId() {
		return locationId;
	}
	@OneToMany(targetEntity = Event.class,fetch = FetchType.LAZY)
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	@Column(name="location_name")
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	@Column(name="location_state")
	public String getLocationState() {
		return locationState;
	}
	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}
	@Column(name="location_country")
	public String getLocationCountry() {
		return locationCountry;
	}
	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}
	
	@Column(name="location_city")
	public String getLocationCity() {
		return locationCity;
	}
	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}
	
	
	
	
	
	
	
}
