package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookRecord;


/**
 * Servlet implementation class RecordNavigationServlet
 */
@WebServlet("/recordNavigationServlet")
public class RecordNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordNavigationServlet() {
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
		String act = request.getParameter("doThisToRecord");
		
		if (act == null) {
			
			getServletContext().getRequestDispatcher("/viewAllRecordsServlet").forward(request, response);
		
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BookRecord bookRecordToDelete = dao.searchForRecordDetailsById(tempId);
				dao.deleteRecord(bookRecordToDelete);
				
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllRecordsServlet").forward(request, response);
			}
		
		} else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BookRecord recordToEdit = dao.searchForRecordDetailsById(tempId);
				request.setAttribute("recordToEdit", recordToEdit);
				
				request.setAttribute("month", recordToEdit.getDateCheckedOut().getMonthValue());
				request.setAttribute("date", recordToEdit.getDateCheckedOut().getDayOfMonth());
				request.setAttribute("year", recordToEdit.getDateCheckedOut().getYear());
				
				OzBookHelper daoForBooks = new OzBookHelper();
				
				request.setAttribute("allBooks", daoForBooks.showAllBooks());
				
				if(daoForBooks.showAllBooks().isEmpty()) {
					request.setAttribute("allBooks", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-record.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllRecordsServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-record.jsp").forward(request, response);
		}
	}

}
