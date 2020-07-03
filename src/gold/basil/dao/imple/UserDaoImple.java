package gold.basil.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import gold.basil.dao.UserDao;
import gold.basil.model.User;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月24日 上午8:35:09 
*/
public class UserDaoImple implements UserDao{
	public Connection conn = null;
	public String sql = "";
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	ResultSet rs = null;
	
	
	@Override
	public User findUser(String userName,String email) throws Exception {
		conn = getConnection();
		sql ="select * from user where username =? or email =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		pstmt.setString(2, email);
		rs=pstmt.executeQuery();
		User user = null;
		while (rs.next()) { //证明存在
			user = new User();
			user.setUsername(rs.getString("username"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getString("sex"));
			user.setPhone(rs.getString("phone"));
			user.setRole(rs.getString("role"));
			user.setState(rs.getInt("state"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String registTime = sdf.format(new Date(rs.getDate("registTime").getTime()));
			user.setRegistTime(registTime);
		}
		
		close(conn, null, pstmt, rs);
		return user;
	}

	@Override
	public int register(User user) throws Exception {
		int result =0;
		conn = getConnection();
		sql = "INSERT INTO `user` (username,`password`,`name`,email,phone,role,state,actcode)"
				+ " VALUES(?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.setString(5, user.getPhone());
		pstmt.setString(6, "user");
		pstmt.setInt(7, 0);
		pstmt.setString(8, user.getActcode());
		result = pstmt.executeUpdate();
		close(conn, null, pstmt, rs);
		return result;
	}

	@Override
	public int active(String actcode) throws Exception {
		int result = 0;
		conn = getConnection();
		sql = "update user set state= 1 where actcode=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, actcode);
		result = pstmt.executeUpdate();
		close(conn, null, pstmt, rs);
		return result;
	}

	
	/**
	 * 登录
	 */
	@Override
	public int loginByUserName(User user) throws Exception {
		int result = 0;
		conn = getConnection();
		sql = "select * from user where state = 1 and username = ? and password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		if(pstmt.executeQuery().next()) {
			result++;
		}
		close(conn, null, pstmt, rs);
		return result;	
		
	}

	@Override
	public int loginByEmail(User user) throws Exception {
		int result = 0;
		conn = getConnection();
		sql = "select * from user where state = 1 and email = ? and password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getEmail());
		pstmt.setString(2, user.getPassword());
		if(pstmt.executeQuery().next()) {
			result++;
		}
		close(conn, null, pstmt, rs);
		return result;	
		
	}
	
	/**
	 * 获取用户信息
	 */
	@Override
	public User getInfoByEmail(String email) throws Exception {
		User user =null;
		conn = getConnection();
		sql ="select * from user where email = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getString("sex"));
			user.setPhone(rs.getString("phone"));
			user.setRole(rs.getString("role"));
			user.setState(rs.getInt("state"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String registTime = sdf.format(new Date(rs.getDate("registTime").getTime()));
			user.setRegistTime(registTime);
		}
		
		close(conn, null, pstmt, rs);
		return user;
	}

	@Override
	public User getInfoByUserName(String username) throws Exception {
		User user =null;
		conn = getConnection();
		sql ="select * from user where username = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getString("sex"));
			user.setPhone(rs.getString("phone"));
			user.setRole(rs.getString("role"));
			user.setState(rs.getInt("state"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String registTime = sdf.format(new Date(rs.getDate("registTime").getTime()));
			user.setRegistTime(registTime);
		}
		
		close(conn, null, pstmt, rs);
		return user;
	}

	
	/**
	 * 更新用户信息
	 */
	@Override
	public int updateInfo(User user) throws Exception {
		int result = 0;
		conn = getConnection();
		sql = "update user set name =? , sex = ? , phone = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getSex());
		pstmt.setString(3, user.getPhone());
		result = pstmt.executeUpdate();
		close(conn, null, pstmt, rs);
		return result;
	}
	
	
	
	/**
	 * 更新密码
	 */
	@Override
	public int updataPassword(User user) throws Exception {
		int result = 0;
		conn = getConnection();
		sql = "update user set password = ? where username = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getUsername());
		result = pstmt.executeUpdate();
		close(conn, null, pstmt, rs);
		return result;
		
	}

	
	/**
	 * 自动登录
	 */
	@Override
	public User autoLogin(String username, String email, String password) throws Exception {
		conn = getConnection();
		sql = "select * from user where username =? or email =? and password =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		rs = pstmt.executeQuery();
		User user = null;
		while(rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getString("sex"));
			user.setPhone(rs.getString("phone"));
			user.setRole(rs.getString("role"));
			user.setState(rs.getInt("state"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String registTime = sdf.format(new Date(rs.getDate("registTime").getTime()));
			user.setRegistTime(registTime);
		}
		close(conn, null, pstmt, rs);
		return user;
	}

}
