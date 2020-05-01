package com.travelapplication.services;

import com.travelapplication.DAO.CategoryDAO;
import com.travelapplication.DAO.EventDAO;
import com.travelapplication.entity.Event;

import java.util.*;

public class EventServices {

	
	private EventDAO eventDAO=null;
	private CategoryDAO categoryDAO=null;
	public EventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	public EventServices() {
		this.setEventDAO(new EventDAO());
	}
	
	public Event createEvent(Event e)
	{
		return getEventDAO().create(e);
	}
	
	public Event updateEvent(Event e)
	{
		return getEventDAO().update(e);
	}
	
	public void DeleteEvent(Integer id)
	{
		getEventDAO().delete(id);
	}
	
	public List<Event> getAll(){
		
		return getEventDAO().getAll("Event.findAll");
	}
	
	public List<Event> getSearchData(String title,String query)
	{
		return getEventDAO().findByTitle(title, query);
	}
	
}
