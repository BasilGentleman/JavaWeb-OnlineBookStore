package gold.basil.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.ShopCart;
import gold.basil.model.User;
import gold.basil.service.OrderService;
import gold.basil.service.imple.OrderServiceImple;

/**
 * Servlet implementation class ShowShopCartServlet
 */
@WebServlet("/showShopCart")
public class ShowShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderService orderService = new OrderServiceImple();
		User user = (User)request.getSession().getAttribute("user");
		Map<Integer, ShopCart> userCart = null;
		int totalAmount =0;
		double totalMoeny = 0.0;
		try {
			userCart = orderService.getShopCart(user.getId());
			Iterator<Map.Entry<Integer, ShopCart>> items = userCart.entrySet().iterator();
			while (items.hasNext()) {
				Map.Entry<Integer, ShopCart> item = items.next();
				totalAmount += item.getValue().getAmount();
				totalMoeny += item.getValue().getMoney();
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.getSession().setAttribute("totalAmount", totalAmount);
		request.getSession().setAttribute("totalMoeny", totalMoeny);
		request.getSession().setAttribute("userCart", userCart);
		request.getRequestDispatcher("/client/jsp/cart.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
