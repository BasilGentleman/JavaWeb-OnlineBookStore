package gold.basil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/** 
* @author Basil
* @version 1.0
* @创建时间 2020年6月22日 上午11:33:13 
* @描述 全局Dao接口，提供数据链接
*/
public interface Dao {
	
	/**
	 * 获取数据源
	 * @return ds 
	 */
	public static DataSource getDataSource() {
		DataSource ds = null;
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/BookStoreDatasource");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ds;
	}
	
	/**
	 * 获取数据库连接
	 * @return conn
	 */
	
	public default Connection getConnection() {
		DataSource ds = getDataSource();
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
		
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 */
	public default void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
}
