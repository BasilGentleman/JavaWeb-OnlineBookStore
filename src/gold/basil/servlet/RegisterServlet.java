package gold.basil.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.User;
import gold.basil.service.imple.UserServiceImpl;
import gold.basil.utils.DigestUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 注册流程
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String name = request.getParameter("nickname");
		String password = DigestUtil.md5Hex(request.getParameter("password"));
		String piccode = (String)request.getSession().getAttribute("piccode");
		String checkCode = request.getParameter("checkCode");
		User user = new User( username, password, name, email, phone,UUID.randomUUID().toString());
		request.getSession().setAttribute("actcode", user.getActcode());
		UserServiceImpl userService = new UserServiceImpl();
	    int result = userService.registerUser(user, piccode, checkCode);
	    if(result == 0) {
	    	//用户存在
	    	request.setAttribute("msg", "用户已存在");
	    } else if(result == 1){
	    	//发送邮件
	    	request.setAttribute("msg", "注册成功，请登录邮箱激活账号 <a href='https://mail.qq.com'>QQ邮箱</a>");
	    } else if(result == 3) {
	    	//验证码有误
	    	request.setAttribute("msg", "验证码有误");
	    } else {
	    	request.setAttribute("msg", "注册失败，请检查相关信息");
	    }
	    
	    request.getRequestDispatcher("/public/jsp/result.jsp").forward(request, response);
	    
	}

}
