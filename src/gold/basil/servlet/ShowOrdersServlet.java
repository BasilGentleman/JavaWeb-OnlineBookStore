package gold.basil.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.Orders;
import gold.basil.model.ShopCart;
import gold.basil.model.User;
import gold.basil.service.OrderService;
import gold.basil.service.imple.OrderServiceImple;

/**
 * Servlet implementation class ShowOrdersServlet
 */
@WebServlet("/showOrders")
public class ShowOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService = new OrderServiceImple();
		User user = (User)request.getSession().getAttribute("user");
		String action = request.getParameter("action");
		List<Orders> orders=null;
		if(action == null) {
			//获取已完成订单的商品
			try {
				orders  = orderService.getOrderItem(user.getId());
				
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else if(action.equals("delete")){
			//获取订单编号
			String order_id = request.getParameter("order_id");
			
			//删除订单项
			try {
				int result = orderService.delOrderItem(order_id, user.getId());
			
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}


			
		}
		request.getSession().setAttribute("orders", orders);
		response.sendRedirect("client/jsp/orders.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
