package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookRecord;
import model.Library;
import model.OzBooks;


/**
 * Servlet implementation class CreateNewRecordServlet
 */
@WebServlet("/createNewRecordServlet")
public class CreateNewRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OzBookHelper obh = new OzBookHelper();
		String recordName = request.getParameter("recordName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String libraryName = request.getParameter("libraryName");
		
		LocalDate ld;
		try {
				ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedBooks = request.getParameterValues("allBooksToAdd");
		List<OzBooks> selectedBooksInRecord = new ArrayList<OzBooks>();
		
		if(selectedBooks != null && selectedBooks.length > 0) {
			for(int i = 0; i<selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				OzBooks b = obh.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInRecord.add(b);
			}
		}
		
		Library library = new Library(libraryName);
		
		BookRecord brd = new BookRecord(recordName, ld, library);
		
		brd.setListOfBooks(selectedBooksInRecord);
		
		BookRecordHelper brh = new BookRecordHelper();
		brh.insertNewRecordDetails(brd);
				
		getServletContext().getRequestDispatcher("/viewAllRecordsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
