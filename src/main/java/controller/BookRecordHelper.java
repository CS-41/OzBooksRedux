/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 9, 2021
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.BookRecord;


public class BookRecordHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OzBooksRedux");
	
	public void insertNewRecordDetails (BookRecord r) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<BookRecord> getRecords() {
		EntityManager em = emfactory.createEntityManager();
		List<BookRecord> allRecords = em.createQuery("SELECT r FROM BookRecord r").getResultList();
		return allRecords;
	}
	
	
	public void deleteRecord (BookRecord recordToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookRecord> typedQuery = 
				em.createQuery("SELECT record from BookRecord record where record.id= :selectedId", BookRecord.class);
		
		typedQuery.setParameter("selectedId", recordToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		BookRecord result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public BookRecord searchForRecordDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BookRecord found = em.find(BookRecord.class, tempId);
		em.close();
		return found;
	}
	
	public void updateRecord(BookRecord toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
