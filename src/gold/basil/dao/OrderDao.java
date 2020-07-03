package gold.basil.dao;

import java.util.List;
import java.util.Map;

import gold.basil.model.Orders;
import gold.basil.model.OrdetItem;
import gold.basil.model.ShopCart;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月28日 下午9:07:40 
*/
public interface OrderDao extends Dao{
	
	/**
	 * 获取购物车
	 *
	 */
	
	public 	List<ShopCart>  getShopCart(int userid) throws Exception;
	
	/**
	 *将商品加入购物车
	 */
	public int insertShopCart(ShopCart shopcart) throws Exception;
	
	/**
	 * 删除图书
	 */
	
	public int delShopCartBook(int user_id,int book_id) throws Exception;
	
	
	/**
	 * 修改图书
	 * @param shopCart
	 * @return
	 */
	public int updateShopCart(ShopCart shopCart) throws Exception;
	
	
	
	/**
	 * 生成订单
	 */
	public int generateOrder(Orders order) throws Exception;
	
	/**
	 * 清空购物车
	 */
	public int cleanShopCart(ShopCart shopcart) throws Exception;
	
	/**
	 * 将商品插入订单表中
	 */
	public int insertOrders(Orders order) throws Exception;
	
	/**
	 * 获取订单列表
	 */
	
	public List<Orders> getOrderItem(int user_id) throws Exception;
	
	/**
	 * 删除订单
	 */
	public int delOrderItem(String order_id) throws Exception;
}
