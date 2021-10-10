import java.time.LocalDate;
import java.util.List;

import controller.BookRecordHelper;
import controller.LibraryHelper;
import model.BookRecord;
import model.Library;

/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */

public class BookRecordTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Library northCentral = new Library("North Central");
		
		//LibraryHelper lh = new LibraryHelper();
		
		//lh.insertLibrary(northCentral);
		
		BookRecordHelper brh = new BookRecordHelper();
		
		BookRecord northCentralRecord = new BookRecord("North Central's Books", LocalDate.now(), northCentral);
		
		brh.insertNewRecordDetails(northCentralRecord);
		
		List<BookRecord> allRecords = brh.getRecords();
		
		for(BookRecord a : allRecords) {
			System.out.println(a.toString());
		}
	
	}

}
