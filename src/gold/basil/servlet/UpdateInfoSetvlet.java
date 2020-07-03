package gold.basil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.User;
import gold.basil.service.UserService;
import gold.basil.service.imple.UserServiceImpl;

/**
 * Servlet implementation class UpdateInfoSetvlet
 */
@WebServlet("/updateInfo")
public class UpdateInfoSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 更新用户信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		UserService userService = new UserServiceImpl();
		User user = (User)request.getSession().getAttribute("user"); //获取session中的用户对象
		user.setName(request.getParameter("name"));
		user.setSex(request.getParameter("sex"));
		user.setPhone( request.getParameter("phone"));
		String msg ="";
		//调用更新用户信息方法
		try {
			int result = userService.updateInfo(user);
			if(result >=1) {
				//更新成功
				msg = "修改成功！";
				
			} else {
				//更新失败
				msg = "修改失败！";
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/public/jsp/result.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
