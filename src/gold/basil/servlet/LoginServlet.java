package gold.basil.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.User;
import gold.basil.service.imple.UserServiceImpl;
import gold.basil.utils.CheckEmail;
import gold.basil.utils.DigestUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 登录流程
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = "";
		String password = "";

		// 从浏览器获取cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("login")) {
					login = cookie.getValue();
				}
				if (cookie.getName().equals("password")) {
					password = cookie.getValue();
				}
			}
		}
		//调用userService
		try {
			User user =new UserServiceImpl().aotuLogin(login, password);
			if (user != null) {
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			} else {
				request.getRequestDispatcher("/public/jsp/login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = DigestUtil.md5Hex(request.getParameter("password"));
		String checkCode = request.getParameter("checkCode");
		String piccode = (String) request.getSession().getAttribute("piccode");
		UserServiceImpl userService = new UserServiceImpl();
		User user = null;

		// 正则表达式判断是邮箱登录还是用户名登录
		if (CheckEmail.checkEmail(login)) {
			user = new User();
			user.setEmail(login);
			user.setPassword(password);
			user.setActcode(UUID.randomUUID().toString());
			request.getSession().setAttribute("actcode", user.getActcode());
			try {
				if (userService.loginByEmail(user, piccode, checkCode) == 1) {
					String flag = request.getParameter("autoLogin");
					if (flag != null && flag.equals("autoLogin")) {
						// 创建cookie
						Cookie emailCookie = new Cookie("login", login);
						Cookie passwordCookie = new Cookie("password", password);
						emailCookie.setMaxAge(60 * 60);
						passwordCookie.setMaxAge(60 * 60);
						// 发送cookie
						response.addCookie(emailCookie);
						response.addCookie(passwordCookie);

					}
					// 设置登录Flag
					request.getSession().setAttribute("loginFlag", Boolean.TRUE);
					request.getSession().setAttribute("user", userService.getInfoByEmail(login));
					request.setAttribute("msg", "登录成功！");
				} else {

					request.setAttribute("msg", "登陆失败！有可能是邮箱未激活或者用户名密码有误");
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else {
			user = new User();
			user.setUsername(login);
			user.setPassword(password);
			try {
				if (userService.loginByUserName(user, piccode, checkCode) == 1) {
					String flag = request.getParameter("autoLogin");
					if (flag != null && flag.equals("autoLogin")) {
						// 创建cookie
						Cookie usernameCookie = new Cookie("login", login);
						Cookie passwordCookie = new Cookie("password", password);
						usernameCookie.setMaxAge(60 * 60);
						passwordCookie.setMaxAge(60 * 60);
						// 发送cookie
						response.addCookie(usernameCookie);
						response.addCookie(passwordCookie);

					}
					// 设置登录Flag
					request.getSession().setAttribute("loginFlag", Boolean.TRUE);
					request.getSession().setAttribute("user", userService.getInfoByUserName(login));
					request.setAttribute("msg", "登录成功！");
				} else {
					request.setAttribute("msg", "登陆失败！");
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher("/public/jsp/result.jsp").forward(request, response);
	}

}
