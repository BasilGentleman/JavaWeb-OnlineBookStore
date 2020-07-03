package gold.basil.service;

import java.util.List;
import java.util.Map;

import gold.basil.model.Orders;
import gold.basil.model.OrdetItem;
import gold.basil.model.ShopCart;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月28日 下午9:15:39 
*/
public interface OrderService {
	/**
	 * 获取购物车
	 * @return
	 * @throws Exception
	 */
	public Map<Integer, ShopCart> getShopCart(int userid) throws Exception;
	
	/**
	 * 将商品插入购物车
	 * @param shopCart
	 * @return
	 * @throws Exception
	 */
	public int insertShopCart(ShopCart shopCart) throws Exception;
	
	/***
	 * 移除购物车商品
	 * @param user_id
	 * @param book_id
	 * @return
	 * @throws Exception
	 */
	public int delShopCartBook(int user_id,int book_id) throws Exception;
	
	
	/**
	 * 更新购物车商品数据
	 * @param shopcart
	 * @return
	 * @throws Exception
	 */
	public int updateShopCart(ShopCart shopcart) throws Exception;
	
	
	/**
	 * 生成订单
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public int generateOrder(Orders order) throws Exception;
	
	/**
	 * 清空购物车
	 * @param shopcart
	 * @return
	 * @throws Exception
	 */
	public int cleanShopCart(ShopCart shopcart) throws Exception;
	
	/**
	 * 将商品插入订单表
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public int insertOrders (Orders order) throws Exception;
	
	/**
	 * 获取订单列表
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public List<Orders> getOrderItem(int user_id) throws Exception;
	
	/**
	 * 删除订单项
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	public int delOrderItem(String order_id,int user_id) throws Exception;
}
