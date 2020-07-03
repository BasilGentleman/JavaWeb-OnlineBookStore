package gold.basil.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gold.basil.dao.BookDao;
import gold.basil.model.Book;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月23日 上午9:45:48 
* @描述 图书功能接口具体实现
*/
public class BookDaoImple implements BookDao{
	public Connection conn = null;
	public String sql = "";
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	ResultSet rs = null;
	
	//图书对象
	Book book = null;
	//图书集合
	List<Book> book_list = null;
	
	
	/**
	 * 查询销量前8的图书
	 */
	@Override
	public List<Book> findHostSales() throws Exception {
		conn = getConnection();
		sql = "select * from book order by sales desc limit 8";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		book_list = new ArrayList<Book>();
		while(rs.next()) {
			book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category"), rs.getString("imgurl"), rs.getString("description"), rs.getInt("sales"));
			book_list.add(book);
		}
		//关闭连接
		close(conn, stmt, null, rs);
		//返回集合
		return book_list;
	}

	
	
	/**
	 * 搜索
	 */
	@Override
	public List<Book> search(String parameter) throws Exception {
		conn = getConnection();
		sql = " select * from book where `name` like '%"+parameter+"%'";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		book_list = new ArrayList<Book>();
		while(rs.next()) {
			book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category"), rs.getString("imgurl"), rs.getString("description"), rs.getInt("sales"));
			book_list.add(book);
		}
		//关闭连接
		close(conn, stmt, null, rs);
		//返回集合
		return book_list;
	}



//	@Override
	public List<Book> search(String parameter, Integer startIndex, Integer pageSize) throws Exception {
//		conn = getConnection();
//		sql = "SELECT * FROM book where `name` like ? limit ?,?";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "%"+parameter+"%");
//		pstmt.setInt(2, startIndex);
//		pstmt.setInt(3, pageSize);
//		rs = pstmt.executeQuery();
//		book_list = new ArrayList<Book>();
//		while(rs.next()) {
//			book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category"), rs.getString("imgurl"), rs.getString("description"), rs.getInt("sales"));
//			book_list.add(book);
//		}
//		//关闭连接
//		close(conn, null, pstmt, rs);
//		//返回集合
		return book_list;
	}
//
//
//
//	@Override
	public int getCountBooks(String name) throws Exception {
//		conn = getConnection();
//		sql ="SELECT COUNT(*) FROM book where `name` LIKE '%"+name+"%'";
//		stmt = conn.createStatement();
//		rs = stmt.executeQuery(sql);
//		int result = rs.getRow();
//		close(conn, stmt, pstmt, rs);
//		return result;
		return 0;
	}


	/**
	 * 按类别查询
	 */
	@Override
	public List<Book> findCategory(String category) throws Exception {
		conn = getConnection();
		sql = "select * from book where category = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, category);
		rs = pstmt.executeQuery();
		book_list = new ArrayList<Book>();
		while(rs.next()) {
			book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category"), rs.getString("imgurl"), rs.getString("description"), rs.getInt("sales"));
			book_list.add(book);
		}
		close(conn, null, pstmt, rs);
		return book_list;
		
	}


	/**
	 * 获取类别
	 */
	@Override
	public List<String> getCategory() throws Exception {
		List<String> category = new ArrayList<String>();
		conn = getConnection();
		sql = "select category from category ";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			category.add(rs.getString("category"));
		}
		close(conn, stmt, null, rs);
		return category;
	}


	/**
	 * 按id查询书籍信息
	 */
	@Override
	public Book getBook(int id) throws Exception {
		conn = getConnection();
		sql = "select * from book where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getDouble("price"));
			book.setCategory(rs.getString("category"));
			book.setImgurl(rs.getString("imgurl"));
			book.setDescription(rs.getString("description"));
			book.setSales(rs.getInt("sales"));
			
		}
		close(conn, null, pstmt, rs);
		return book;
	}


}
