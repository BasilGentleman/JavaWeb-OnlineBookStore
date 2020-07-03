package gold.basil.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.User;
import gold.basil.service.imple.UserServiceImpl;
import gold.basil.utils.DigestUtil;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 更新用户密码
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String oldp = DigestUtil.md5Hex(request.getParameter("oldp"));
		String newp = DigestUtil.md5Hex(request.getParameter("newp"));
		User user = (User)request.getSession().getAttribute("user");
		if (oldp.equals(user.getPassword())) {   //输入旧密码与数据库密码匹配
			user.setPassword(newp);
			int result = 0;
			//调用修改密码方法
			try {
				result = new UserServiceImpl().updatePassword(user);
				if (result >=1) {
					//修改成功
					out.print("<script language='javascript'>alert('修改成功！');window.close();</script>");
				} else {
					//修改失败
					out.print("<script language='javascript'>alert('修改失败！');window.close();</script>");
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			
		} else {
			//不匹配
			out.print("<script language='javascript'>alert('旧密码有误！');window.close();</script>");
			
		}
		
		
		
	}

}
