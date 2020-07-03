package gold.basil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gold.basil.service.imple.UserServiceImpl;


/**
 * Servlet implementation class ActiveServlet
 */
@WebServlet("/active")
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 激活流程
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String actcode = request.getParameter("actcode"); // 获取注册激活码
		HttpSession session = request.getSession(); // 获取存入session的激活码
		String sessionActcode = session.getAttribute("actcode").toString();
		if (actcode.equals(sessionActcode)) { // 激活码匹配
			UserServiceImpl user = new UserServiceImpl();
			int result;
			try {
				result = user.active(actcode);
				if(result == 1){
					request.getRequestDispatcher("public/jsp/login.jsp").forward(request, response);
				}else{
					request.setAttribute("msg", "激活失败！");
					request.getRequestDispatcher("public/jsp/result.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}//激活账号
		
		} else {
			request.setAttribute("msg", "激活码不匹配，激活失败！");
			request.getRequestDispatcher("public/jsp/result.jsp").forward(request, response);
 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
