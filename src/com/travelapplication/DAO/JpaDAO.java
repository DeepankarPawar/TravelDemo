package com.travelapplication.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.travelapplication.entity.Users;

import java.util.*;
public class JpaDAO<T> {

	
	
	
	private static EntityManager entityManager=null;
	
	static {
		

			 entityManager=Persistence.createEntityManagerFactory("TravelWebsite").createEntityManager();
		}
	
	
	public JpaDAO() {
		
	}
	
	
	
	public T create(T t) {
	
	entityManager.getTransaction().begin();
	entityManager.persist(t);
	entityManager.flush();
	entityManager.refresh(t);
	entityManager.getTransaction().commit();
		
	return t;
	}
	
	public T update(T t)
	{
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		return t;
	}
	
	public void delete(Class<T> cl,Object id)
	{
		entityManager.getTransaction().begin();
		Users user=(Users) entityManager.getReference(cl,id);
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<T> getAll(String Query)
	{
		entityManager.getTransaction().begin();
		javax.persistence.Query q=entityManager.createNamedQuery(Query);
		entityManager.close();
		return q.getResultList();
	}
	
	public List<T> getSingleData(String Query,Map<String,String> parameters) {
		
		entityManager.getTransaction().begin();
		Query query=entityManager.createNamedQuery(Query);
		for(Map.Entry<String ,String> entry:parameters.entrySet())
		{
				query.setParameter(entry.getKey(),entry.getValue());
		}
	
		entityManager.close();
		return query.getResultList();
		
		
		
	}
	
	public T find (Class<T> cl,Object id)
	{
		entityManager.getTransaction().begin();
		T t=entityManager.find(cl,id);
		if(t!=null)
		{
			entityManager.refresh(t);
		}
		entityManager.close();
		return t;
	
	}
	
}
