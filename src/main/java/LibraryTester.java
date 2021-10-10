import java.util.List;

import controller.LibraryHelper;
import model.Library;

/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */

public class LibraryTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Library central = new Library("Central");
		
		LibraryHelper lh = new LibraryHelper();
		
		lh.insertLibrary(central);
		
		List<Library> allLibraries = lh.showAllLibraries();
		for(Library a: allLibraries) {
			System.out.println(a.toString());
		}
		
	}

}
