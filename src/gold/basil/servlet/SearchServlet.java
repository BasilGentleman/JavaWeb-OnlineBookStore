package gold.basil.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.Book;
import gold.basil.model.Page;
import gold.basil.service.imple.BookServiceImple;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 模糊搜索
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int page ;
//		if ( request.getParameter("id") ==null) {
//			page = 1;
//		} else {
//			page = Integer.parseInt(request.getParameter("id"));
//		}
		String parameter = request.getParameter("book_name");
		BookServiceImple bookService = new BookServiceImple();
		
		String [] publishs = {"人民出版社","清华大学出版社","北京大学出版社","北京传媒大学出版社"};
		String [] priceRanges = {"10-99","100-199","200-299","300以上"};
		String []discounts = {"1折","2折","3折","4折"};
 		try {
			List<Book> booklist = bookService.getNameBooks(parameter);
// 			Page page = bookService.getNameBooks(parameter,1, 12);
//			List<Book> booklist = page.getBookList();
// 			List<Book> booklist = bookService.getNameBooks(parameter,page,12);
			
//			for (Book book : booklist) {
//				System.out.println(book);
//			}
		
			request.getSession().setAttribute("booklist", booklist);
			request.getSession().setAttribute("parameter", parameter);
			request.getSession().setAttribute("publishs", publishs);
			request.getSession().setAttribute("priceRanges", priceRanges);
			request.getSession().setAttribute("discounts", discounts);
			
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		//重定向到前台搜索页
		request.getRequestDispatcher("client/jsp/search.jsp").forward(request, response);
//		response.sendRedirect("client/jsp/search.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
