package gold.basil.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.Book;
import gold.basil.service.BookService;
import gold.basil.service.imple.BookServiceImple;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类显示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取book业务层对象
		BookService bookService = new BookServiceImple();
		List<String> categorys = null;
		List<Book> booklist = null;
		String category = request.getParameter("category");
		try {
			categorys = bookService.getCategory();
			if (category != null) {		//未点击分类时为 null 显示销量前八的图书
				booklist = bookService.getCategoryBooks(category);
			} else {
				booklist = bookService.getHostSalesBooks();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("categorys", categorys);
		request.getSession().setAttribute("booklist", booklist);
		request.getRequestDispatcher("/client/jsp/category.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
 