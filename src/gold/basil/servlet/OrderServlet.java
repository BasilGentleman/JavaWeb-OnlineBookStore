package gold.basil.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import gold.basil.model.Book;
import gold.basil.model.Orders;
import gold.basil.model.ShopCart;
import gold.basil.model.User;
import gold.basil.service.BookService;
import gold.basil.service.OrderService;
import gold.basil.service.imple.BookServiceImple;
import gold.basil.service.imple.OrderServiceImple;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService = new OrderServiceImple();
		BookService bookService = new BookServiceImple();
		//获取购物车
		Map<Integer, ShopCart> userCart = (HashMap<Integer, ShopCart>)request.getSession().getAttribute("userCart");
		List<ShopCart> shopcart = new ArrayList<ShopCart>();
		Map<Integer, ShopCart> orders = new HashMap<Integer, ShopCart>();
		//获取用户对象信息
		User user = (User) request.getSession().getAttribute("user");
		ShopCart sp = null;
		int id = user.getId();
		//遍历map集合获取订单信息
		Iterator<Map.Entry<Integer, ShopCart>> it = userCart.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, ShopCart> item = it.next();
			sp = new ShopCart();
			sp.setBook_id(item.getKey());
			sp.setUser_id(id);
			sp.setAmount(item.getValue().getAmount());
			sp.setMoney(item.getValue().getMoney());
			shopcart.add(sp);
			orders.put(item.getKey(), item.getValue());
		}
		//生成订单
		double money = 0.0;
		Book book = null;
		int num = 0;
		
		String receiveName = request.getParameter("receiveName");
		String receivePhone = request.getParameter("receivePhone");
		String receiveAddr = request.getParameter("receiveAddr");
		String orderTime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String orderCode = new SimpleDateFormat("yyyy-MM-dd-HHmmss-").format(new Date())+UUID.randomUUID().toString();
		Orders order = null;
		for (ShopCart shopCart2 : shopcart) {
			order = new Orders();
			order.setUser_id(user.getId());
			order.setReceiveName(receiveName);
			order.setReceivePhone(receivePhone);
			order.setReceiveAddr(receiveAddr);
			order.setOrder_id(orderCode);
			money += shopCart2.getMoney();
			try {
				book = bookService.getBook(shopCart2.getBook_id());
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			order.setBook(book);
			order.setBook_id(order.getBook().getId());
			order.setNum(shopCart2.getAmount());
			order.setMoney(money);
			//插入订单列表
			try {
				orderService.insertOrders(order);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		int result = 0;
		try {
			result = orderService.generateOrder(order);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if (result >=0 ) {
			
			//清空购物车
			for (ShopCart shopCart2 : shopcart) {
				try {
					orderService.cleanShopCart(shopCart2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getSession().setAttribute("orders", orders);
		} else {
			System.out.println("失败");
		}
		
		//转发主页
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
