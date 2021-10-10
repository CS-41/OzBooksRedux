/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 9, 2021
 */
package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library")
public class Library {
	@Id
	@GeneratedValue
	private int id;
	private String libraryName;
	
	public Library() {
		super();
	}
	
	public Library(int id, String libraryName) {
		super();
		this.id = id;
		this.libraryName = libraryName;
	}
	
	public Library(String libraryName) {
		super();
		this.libraryName = libraryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", libraryName=" + libraryName + "]";
	}
		
}
