package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OzBooks;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OzBookHelper dao = new OzBookHelper();
		
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		OzBooks bookToUpdate = dao.searchForBookById(tempId);
		bookToUpdate.setBookTitle(title);
		bookToUpdate.setPublishDate(Integer.parseInt(date));
				
		dao.updateBook(bookToUpdate);

		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
		
		
	}

}
