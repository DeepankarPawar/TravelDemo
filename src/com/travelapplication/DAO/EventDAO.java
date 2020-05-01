package com.travelapplication.DAO;

import java.util.List;
import java.util.*;

import javax.persistence.EntityManager;

import com.travelapplication.entity.Event;

public class EventDAO extends JpaDAO<Event> implements BaseDAO<Event>  {

	public EventDAO()
	{
		
	}
	
	@Override
	public Event get(Object id) {
		// TODO Auto-generated method stub
		return super.find(Event.class, id);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		super.delete(Event.class, id);
	}

	@Override
	public List<Event> getAll() {
		// TODO Auto-generated method stub
		return super.getAll("Event.findAll");
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Event> findByTitle(String title,String query) {
		Map<String,String> parameters=new HashMap<String,String>();
		parameters.put("title",title);
		List<Event> events=super.getSingleData(query, parameters);
		if(events!=null )
		{
			
			return events;
			
			
		}
		return null;
		}
	
	
	
	
	
	

	public List<Event> listByCategory(Integer id)
	{
		Map<String,String> parameters=new HashMap<String,String>();
		parameters.put("categoryId",id.toString());
		List<Event> events=super.getSingleData("Event.findByCategory", parameters);
		if(events!=null )
		{
			
			return events;
			
			
		}
		return null;
		}
		
	

	public List<Event> search(String keyword){
		
		List<Event> events=super.getAll("Event.getAll");
		if(events!=null && events.size()!=0)
		{	
			for(Event e:events)
			{
				if(!e.getEventName().contains(keyword))
				{
					events.remove(e);
				}
			}
			return events;
		}
		return null;
		}
	
	

}