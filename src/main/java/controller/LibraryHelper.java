/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Library;


public class LibraryHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OzBooksRedux");
	
	public void insertLibrary(Library l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Library> showAllLibraries() {
		EntityManager em = emfactory.createEntityManager();
		List<Library> allLibraries = em.createQuery("SELECT l FROM Library l").getResultList();
		return allLibraries;
	}
	
	public Library findLibrary(String libraryToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Library> typedQuery = em.createQuery("select li from Library li where li.libraryName =:selectedLibraryName", Library.class);
		typedQuery.setParameter("selectedLibraryName", libraryToLookUp);
		typedQuery.setMaxResults(1);
		
		Library foundLibrary;
		try {
			foundLibrary = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundLibrary = new Library(libraryToLookUp);
		}
		em.close();
		
		return foundLibrary;
	}
	
}
