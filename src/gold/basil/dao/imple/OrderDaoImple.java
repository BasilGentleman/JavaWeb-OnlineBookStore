package gold.basil.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gold.basil.dao.OrderDao;
import gold.basil.model.Orders;
import gold.basil.model.OrdetItem;
import gold.basil.model.ShopCart;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月28日 下午9:09:29 
*/
public class OrderDaoImple implements OrderDao {
	public Connection conn = null;
	public String sql = "";
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	ResultSet rs = null;
	
	/**
	 * 获取购物车
	 */
	@Override
	public List<ShopCart> getShopCart(int userid) throws Exception {
		conn = getConnection();
		sql = "select * from shopcart where user_id=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userid);
		 List<ShopCart> shopcarts = new ArrayList<ShopCart>();
		ShopCart sc = null;
		rs = pstmt.executeQuery();
		while(rs.next()) {
			sc = new ShopCart(rs.getInt("user_id"), rs.getInt("book_id"), rs.getInt("amount"), rs.getDouble("money"));
			sc.setId(rs.getInt("id"));
			shopcarts.add(sc);
		}
		close(conn, null, pstmt, rs);
		return shopcarts;
	}
	
	
	
	/**
	 * 插入数据库
	 */
	@Override
	public int insertShopCart(ShopCart shopcart) throws Exception {
		int result = 0;
		conn = getConnection();
		sql = "insert into shopcart (user_id,book_id,amount,money) values (?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, shopcart.getUser_id());
		pstmt.setInt(2, shopcart.getBook_id());
		pstmt.setInt(3, shopcart.getAmount());
		pstmt.setDouble(4, shopcart.getMoney());
		if(pstmt.execute()) {
			result++;
		}
		System.out.println(result);
		close(conn, null, pstmt, rs);
		return result;
	}


	/**
	 * 删除购物车商品
	 */
	@Override
	public int delShopCartBook(int user_id,int book_id) throws Exception {
		int result = 0;
		conn = getConnection();
		sql = "delete  from shopcart where user_id =? and book_id =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setInt(2, book_id);
		result = pstmt.executeUpdate();
		close(conn, null, pstmt, rs);
		return result;
	}


	/**
	 * 更新购物车
	 */
	@Override
	public int updateShopCart(ShopCart shopCart) throws Exception {
		int result =0;
		conn = getConnection();
		sql = "update shopcart set amount = ?,money =? where user_id =? and book_id =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, shopCart.getAmount());
		pstmt.setDouble(2, shopCart.getMoney());
		pstmt.setInt(3, shopCart.getUser_id());
		pstmt.setInt(4, shopCart.getBook_id());
		result = pstmt.executeUpdate();
		close(conn, null, pstmt, rs);
		return result;
	}


	/**
	 * 生成订单
	 */
	@Override
	public int generateOrder(Orders order) throws Exception {
		int result = 0;
		conn = getConnection();
		sql = "insert into orders (order_id,user_id,money,receiverName,receiverPhone,receiverAddr,state) values (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, order.getOrder_id());
		pstmt.setInt(2, order.getUser_id());
		pstmt.setDouble(3, order.getMoney());
		pstmt.setString(4, order.getReceiveName());
		pstmt.setString(5, order.getReceivePhone());
		pstmt.setString(6, order.getReceiveAddr());
		pstmt.setInt(7, 0);
		boolean b =pstmt.execute();
		if(b) {
			result++;
		}
		close(conn, null, pstmt, rs);	
		return result;
	}


	/**
	 * 清空购物车
	 */
	@Override
	public int cleanShopCart(ShopCart shopcart) throws Exception {
		int result = 0;
		conn = getConnection(); 
		sql = "delete from shopcart where user_id = ? and book_id= ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, shopcart.getUser_id());
		pstmt.setInt(2, shopcart.getBook_id());
		result = pstmt.executeUpdate();
		close(conn, null, pstmt, rs);
		return result;
	}


	/**
	 * 将商品插入订单表
	 */
	@Override
	public int insertOrders(Orders order) throws Exception {
		int result = 0;
		conn =getConnection();
		sql = "insert into orderitem (order_id,user_id,book_id,num) values (?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, order.getOrder_id());
		pstmt.setInt(2, order.getUser_id());
		pstmt.setInt(3, order.getBook_id());
		pstmt.setInt(4, order.getNum());
		if(pstmt.execute()) {
			result++;
		}
		close(conn, null, pstmt, rs);
		return result;
	}


	//获取订单列表
	@Override
	public List<Orders> getOrderItem(int user_id) throws Exception {
		conn = getConnection();
		sql = "select * from orderitem,orders where orderitem.user_id = ? and orders.user_id =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setInt(2, user_id);
//		Map<Integer, Orders> map= new HashMap<Integer, Orders>();
		List<Orders> orders = new ArrayList<Orders>();
		Orders order = null;
		rs = pstmt.executeQuery();
		while(rs.next()) {
			order = new Orders(); 
			order.setId(rs.getInt("id"));
			order.setOrder_id(rs.getString("order_id"));
			order.setUser_id(rs.getInt("user_id"));
			order.setBook_id(rs.getInt("book_id"));
			order.setNum(rs.getInt("num"));
			order.setMoney(rs.getDouble("money"));
			order.setReceiveName(rs.getString("receiverName"));
			order.setReceivePhone(rs.getString("receiverPhone"));
			order.setReceiveAddr(rs.getString("receiverAddr"));
			order.setState(rs.getInt("state"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String orderTime = sdf.format(new Date(rs.getTimestamp("orderTime").getTime()));
			order.setOrderTime(orderTime);
			orders.add(order);
		}
		close(conn, null, pstmt, rs);
		return orders;
	}


	/**
	 * 删除订单项
	 */
	@Override
	public int delOrderItem(String order_id) throws Exception {
		int result = 0;
		conn = getConnection();
		sql ="delete orderitem,orders  from orderitem , orders where orderitem.order_id = ? and orders.order_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,order_id);
		pstmt.setString(2,order_id);
		result = pstmt.executeUpdate();
		close(conn, null, pstmt, rs);
		return result;
	}

	
	

}
