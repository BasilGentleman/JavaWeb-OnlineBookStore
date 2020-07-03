package gold.basil.service.imple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.batch.Main;

import gold.basil.dao.BookDao;
import gold.basil.dao.OrderDao;
import gold.basil.dao.imple.BookDaoImple;
import gold.basil.dao.imple.OrderDaoImple;
import gold.basil.model.Orders;
import gold.basil.model.OrdetItem;
import gold.basil.model.ShopCart;
import gold.basil.service.OrderService;
import gold.basil.servlet.OrderServlet;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月28日 下午9:16:50 
*/
public class OrderServiceImple implements OrderService {
	OrderDao ordefDao  = new OrderDaoImple();
	BookDao bookDao = new BookDaoImple();
	
	/**
	 * 获取购车
	 */
	@Override
	public Map<Integer, ShopCart> getShopCart(int userid) throws Exception {
		ArrayList<ShopCart> scs=(ArrayList<ShopCart>)ordefDao.getShopCart(userid);
		Map<Integer, ShopCart> map= new HashMap<Integer, ShopCart>();
		int amount = 0;
		for (ShopCart item : scs) {
			item.setBook(bookDao.getBook(item.getBook_id()));
			map.put(item.getBook_id(), item);
		}
		return map;
	}
	
	/**
	 * 实现插入购物车
	 */
	@Override
	public int insertShopCart(ShopCart shopCart) throws Exception {
		int result = 0;
		//获取购物车
		 Map<Integer, ShopCart> map = new HashMap<Integer, ShopCart>();
		 Iterator< Map.Entry<Integer, ShopCart>> items =map.entrySet().iterator();
		 while(items.hasNext()) {
			 Map.Entry<Integer, ShopCart> item = items.next();
			 if(item.getKey()==shopCart.getBook_id()) {
				 	shopCart.setAmount(shopCart.getAmount()+1);
					shopCart.setMoney(item.getValue().getBook().getPrice()*1+shopCart.getMoney());
					ordefDao.updateShopCart(shopCart);
					break;
			 }
		 }
		 result = ordefDao.insertShopCart(shopCart);
		 return result;
	}

	
	/**
	 * 移除购物车商品
	 */
	@Override
	public int delShopCartBook(int user_id, int book_id) throws Exception {
		
		return ordefDao.delShopCartBook(user_id, book_id);
	}

	/**
	 * 更新购物车商品数据
	 */
	@Override
	public int updateShopCart(ShopCart shopcart) throws Exception {
		return ordefDao.updateShopCart(shopcart);
	}

	/**
	 * 生成订单信息
	 */
	@Override
	public int generateOrder(Orders order) throws Exception {
		return ordefDao.generateOrder(order);
	}
	
	/**
	 * 清空购物车
	 */
	@Override
	public int cleanShopCart(ShopCart shopcart) throws Exception {
		return ordefDao.cleanShopCart(shopcart);
	}
	
	/**
	 * 将商品插入订单表
	 */
	@Override
	public int insertOrders(Orders order) throws Exception {
		// TODO 自动生成的方法存根
		return ordefDao.insertOrders(order);
	}

	@Override
	public  List<Orders> getOrderItem(int user_id) throws Exception {
		 List<Orders> orders = ordefDao.getOrderItem(user_id);
		 for (Orders order : orders) {
			order.setBook(bookDao.getBook(order.getBook_id()));
		}
		return orders;
	}

	@Override
	public int delOrderItem(String order_id ,int user_id) throws Exception {
		int result=0;
		List<Orders> orders = ordefDao.getOrderItem(user_id);
		for (Orders order : orders) {
			if(order.getOrder_id().equals(order_id) ) {
				if(order.getState() == 1) {
					result=ordefDao.delOrderItem(order_id);
				}
			}
		}
		return result;
	}

}
