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
 * Servlet implementation class EditRecordServlet
 */
@WebServlet("/editRecordServlet")
public class EditRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		BookRecordHelper dao = new BookRecordHelper();
		OzBookHelper ozh = new OzBookHelper();
		LibraryHelper lh = new LibraryHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BookRecord recordToUpdate = dao.searchForRecordDetailsById(tempId);
		
		String newRecordName = request.getParameter("recordName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String libraryName = request.getParameter("libraryName");
		Library newLibrary = lh.findLibrary(libraryName);
		
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedBooks = request.getParameterValues("allBooksToAdd");
			List<OzBooks> selectedBooksInRecord = new ArrayList<OzBooks>();
			
			for(int i = 0; i<selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				OzBooks b = ozh.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInRecord.add(b);
			}
			
			recordToUpdate.setListOfBooks(selectedBooksInRecord);
		} catch (NullPointerException ex) {
			List<OzBooks> selectedBooksInRecord = new ArrayList<OzBooks>();
			recordToUpdate.setListOfBooks(selectedBooksInRecord);
		}
		
		recordToUpdate.setRecordName(newRecordName);
		recordToUpdate.setDateCheckedOut(ld);
		recordToUpdate.setLibrary(newLibrary);
		
		dao.updateRecord(recordToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllRecordsServlet").forward(request, response);
	}

}
