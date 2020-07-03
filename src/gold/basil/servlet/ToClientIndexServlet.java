package gold.basil.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.Book;
import gold.basil.service.imple.BookServiceImple;
/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月23日 上午10:08:40 
* @描述 首页响应
*/
@WebServlet("/index")
public class ToClientIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 显示主页
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServiceImple bookService = new BookServiceImple();
		//获取数据
		try {
			List<Book> booklist = bookService.getHostSalesBooks();
			request.getSession().setAttribute("booklist", booklist);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//重定向到前台主页
		response.sendRedirect("client/jsp/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
