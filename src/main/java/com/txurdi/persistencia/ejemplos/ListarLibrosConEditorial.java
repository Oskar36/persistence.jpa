package com.txurdi.persistencia.ejemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.persistencia.model.Editorial;
import com.txurdi.persistencia.model.Libro;

public class ListarLibrosConEditorial {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Editorial e1 = new Editorial("Lmao");
		Libro l1 = new Libro("Tokyo Revengers",e1);
		Libro l2 = new Libro("Love is war",e1);
		
		em.persist(e1);
		em.persist(l1);
		em.persist(l2);
		
		em.getTransaction().commit();
		
		em.close();
	}
}
