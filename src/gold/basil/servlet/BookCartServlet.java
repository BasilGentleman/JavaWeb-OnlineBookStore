package gold.basil.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gold.basil.model.Book;
import gold.basil.model.ShopCart;
import gold.basil.model.User;
import gold.basil.service.BookService;
import gold.basil.service.OrderService;
import gold.basil.service.imple.BookServiceImple;
import gold.basil.service.imple.OrderServiceImple;

/**
 * Servlet implementation class BookCartServlet
 */
@WebServlet("/bookCart")
public class BookCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			BookService bookService = new BookServiceImple();
			OrderService orderService = new OrderServiceImple();
			Book book = null;
			//获取数量
			int amount = Integer.parseInt(request.getParameter("amount"));
			//判断用户是否已登录
			User user = (User)request.getSession().getAttribute("user");
			if (user == null) {
				//未登录
				request.setAttribute("msg", "您尚未登录");
				request.getRequestDispatcher("/public/jsp/result.jsp").forward(request, response);
			} else {
				//已登录,获取用户信息

				//获取书本id
				int id = Integer.parseInt(request.getParameter("id"));
//				Map<Integer,ShopCart> userCart =(HashMap<Integer, ShopCart>)request.getSession().getAttribute("userCart");
				Map<Integer, ShopCart> userCart =null;
				try {
					userCart = orderService.getShopCart(user.getId());
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
		
			
				//获取图书信息
				try {
					book = bookService.getBook(id);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//购物车为空，用户第一次购买
				if (userCart.isEmpty()) {
					ShopCart shopCart = new ShopCart(user.getId(),id,amount,book.getPrice()*amount,book);
					try {
						orderService.insertShopCart(shopCart);
//						userCart = new HashMap<Integer, ShopCart>();
						userCart.put(id,shopCart);
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
					
				} else {
					if(userCart.get(id) == null) {
						try {
							ShopCart shopCart = new ShopCart(user.getId(),id,amount,book.getPrice()*amount,book);
							orderService.insertShopCart(shopCart);
							userCart.put(id,shopCart);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						//该书籍已在购物车中
						try {
							ShopCart shopCart = userCart.get(id);
							shopCart.setAmount(shopCart.getAmount()+1);
							shopCart.setMoney(book.getPrice()*1+shopCart.getMoney());
							orderService.updateShopCart(shopCart);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}				
					
			}
				

				int totalAmount = 0;
				double totalMoeny = 0.0;
				Iterator<Map.Entry<Integer,ShopCart>>it = userCart.entrySet().iterator();
				while(it.hasNext()) {
					Map.Entry<Integer,ShopCart> item = it.next();
					totalAmount += item.getValue().getAmount();
					totalMoeny +=item.getValue().getMoney();
				}
				
				request.getSession().setAttribute("totalAmount", totalAmount);
				request.getSession().setAttribute("totalMoeny", Double.parseDouble(new DecimalFormat("#.00").format(totalMoeny)));
				request.getSession().setAttribute("userCart", userCart);
				request.getRequestDispatcher("/client/jsp/cart.jsp").forward(request, response);
		} 
			

		} else {
			switch (action) {
				case "delete":
					DeleteBook(request,response);
					break;
				case "upbook":
					UpBook(request,response);
					break;
				case "downbook":
					DownBook(request,response);
					break;
			}
		}

		
		
	}
	//减少指定图书
	private void DownBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImple();
		OrderService orderService = new OrderServiceImple();
		User user = (User)request.getSession().getAttribute("user");
		//获取图书id
		int id = Integer.parseInt(request.getParameter("id"));
		//获取商品数量
		int totalAmount = (int) request.getSession().getAttribute("totalAmount");
		//获取金额
		double totalMoeny = (double) request.getSession().getAttribute("totalMoeny");
		//获取购物车
		Map<Integer, ShopCart> userCart = (HashMap<Integer, ShopCart>)request.getSession().getAttribute("userCart");
		ShopCart shopcart = null;
		//遍历hashmap
		Iterator<Map.Entry<Integer, ShopCart>> it =	userCart.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, ShopCart> item = it.next();
			if(id == item.getKey()) {
				if(item.getValue().getAmount() >1) {
					item.getValue().setAmount(item.getValue().getAmount()-1);
					totalAmount -=1;
					item.getValue().setMoney(item.getValue().getMoney()-item.getValue().getBook().getPrice());
					totalMoeny -= item.getValue().getBook().getPrice();
					shopcart = item.getValue();
				}
			}
		}
		try {
			orderService.updateShopCart(shopcart);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.getSession().setAttribute("totalAmount", totalAmount);
		request.getSession().setAttribute("totalMoeny", Double.parseDouble(new DecimalFormat("#.00").format(totalMoeny)));
		request.getSession().setAttribute("userCart", userCart);
		request.getRequestDispatcher("/client/jsp/cart.jsp").forward(request, response);
	}
	//增加指定图书
	private void UpBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImple();
		OrderService orderService = new OrderServiceImple();
		User user = (User)request.getSession().getAttribute("user");
		//获取图书id
		int id = Integer.parseInt(request.getParameter("id"));
		//获取商品数量
		int totalAmount = (int) request.getSession().getAttribute("totalAmount");
		//获取金额
		double totalMoeny = (double) request.getSession().getAttribute("totalMoeny");
		ShopCart shopcart = null;
		//获取购物车
		Map<Integer, ShopCart> userCart = (HashMap<Integer, ShopCart>)request.getSession().getAttribute("userCart");
		//遍历hashmap
		Iterator<Map.Entry<Integer, ShopCart>> it =	userCart.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, ShopCart> item = it.next();
			if(id == item.getKey()) {
				item.getValue().setAmount(item.getValue().getAmount()+1);
				totalAmount +=1;
				item.getValue().setMoney(item.getValue().getMoney()+item.getValue().getBook().getPrice());
				totalMoeny += item.getValue().getBook().getPrice();
				shopcart = item.getValue();
			}
		}
		try {
			orderService.updateShopCart(shopcart);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.getSession().setAttribute("totalAmount", totalAmount);
		request.getSession().setAttribute("totalMoeny", Double.parseDouble(new DecimalFormat("#.00").format(totalMoeny)));
		request.getSession().setAttribute("userCart", userCart);
		request.getRequestDispatcher("/client/jsp/cart.jsp").forward(request, response);
	}
	//删除图书
	private void DeleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImple();
		OrderService orderService = new OrderServiceImple();
		User user = (User)request.getSession().getAttribute("user");
		//获取图书id
		int id = Integer.parseInt(request.getParameter("id"));
		//获取商品数量
		int totalAmount = (int) request.getSession().getAttribute("totalAmount");
		//获取金额
		double totalMoeny = (double) request.getSession().getAttribute("totalMoeny");
		//获取购物车
		Map<Integer, ShopCart> userCart = (HashMap<Integer, ShopCart>)request.getSession().getAttribute("userCart");
		//遍历hashmap
		Iterator<Map.Entry<Integer, ShopCart>> it =	userCart.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, ShopCart> item = it.next();
			//找到则数量，金额相对减一，并删除该map
			if(id== item.getKey()) {
				totalAmount-=item.getValue().getAmount();
				totalMoeny-=item.getValue().getMoney();
				it.remove();
				try {
					orderService.delShopCartBook(user.getId(), id);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}

		request.getSession().setAttribute("totalAmount", totalAmount);
		request.getSession().setAttribute("totalMoeny", Double.parseDouble(new DecimalFormat("#.00").format(totalMoeny)));
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
