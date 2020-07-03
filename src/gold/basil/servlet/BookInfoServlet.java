package gold.basil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.Book;
import gold.basil.service.BookService;
import gold.basil.service.imple.BookServiceImple;

/**
 * Servlet implementation class BookInfoServlet
 */
@WebServlet("/bookInfo")
public class BookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 按id查询书籍信息
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取书籍id
		int id = Integer.parseInt(request.getParameter("bookid"));
		//获取书籍信息
		BookService bookService = new BookServiceImple();
		Book book = null;
		try {
			book = bookService.getBook(id);
			
			if (book != null) {
				request.getSession().setAttribute("book", book);
				request.getRequestDispatcher("/client/jsp/book/book.jsp").forward(request, response);
				return;
			} else {
				request.setAttribute("msg", "该书籍不存在！");
				request.getRequestDispatcher("/public/jsp/result.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
