package com.travelapplication.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserTest {

	
	public static void main (String a[]) {
		
		
		/*
		 * Users u=new Users(); u.setEmail("Javeline"); u.setFullName("jo");
		 * u.setPassword("N");
		 */
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("TravelWebsite");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Category c=new Category();
		c.setName("Trek");
		Category c2=new Category();
		c2.setName("Camp");

		
		em.persist(c);
		em.persist(c2);
		
		
		 em.getTransaction().commit();
		
		//em.createQuery("DELETE FROM Users").executeUpdate();
		
		//em.getTransaction().commit();
		/*
		 * Users u=new Users(); u.setUser_id(4); u.setEmail("p@gmail.com");
		 * u.setFullName("NameIsEmial"); em.merge(u);
		 */
		/*
		 * em.getTransaction().begin(); u=em.find(Users.class,u.getUser_id());
		 * u.setFullName("deepya"); u.setEmail("pdeepya@gmail.com"); em.merge(u);
		 * em.getTransaction().commit();
		 */
		//System.out.println(u.getFullName());
		em.close();
		emf.close();
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
