/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 9, 2021
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BookRecord {
	@Id
	@GeneratedValue
	private int id;
	private String recordName;
	private LocalDate dateCheckedOut;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Library library;
	@OneToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<OzBooks> listOfBooks;
	
	public BookRecord() {
		super();
	}
	
	public BookRecord(int id, String recordName, LocalDate dateCheckedOut, Library library, List<OzBooks> listOfBooks) {
		super();
		this.id = id;
		this.recordName = recordName;
		this.dateCheckedOut = dateCheckedOut;
		this.library = library;
		this.listOfBooks = listOfBooks;
	}
	
	public BookRecord(String recordName, LocalDate dateCheckedOut, Library library, List<OzBooks> listOfBooks) {
		super();
		this.recordName = recordName;
		this.dateCheckedOut = dateCheckedOut;
		this.library = library;
		this.listOfBooks = listOfBooks;
	}

	public BookRecord(String recordName, LocalDate dateCheckedOut, Library library) {
		super();
		this.recordName = recordName;
		this.dateCheckedOut = dateCheckedOut;
		this.library = library;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public LocalDate getDateCheckedOut() {
		return dateCheckedOut;
	}

	public void setDateCheckedOut(LocalDate dateCheckedOut) {
		this.dateCheckedOut = dateCheckedOut;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public List<OzBooks> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(List<OzBooks> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}

	@Override
	public String toString() {
		return "BookRecord [id=" + id + ", recordName=" + recordName + ", dateCheckedOut=" + dateCheckedOut
				+ ", library=" + library + ", listOfBooks=" + listOfBooks + "]";
	}
		
}
