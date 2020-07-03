package gold.basil.dao;

import gold.basil.model.User;


/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月24日 上午8:33:44 
*/
public interface UserDao extends Dao {
	/**
	 * 查询用户
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public User findUser(String userName,String email) throws Exception;
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int register(User user) throws Exception;
	
	/**
	 * 激活账户
	 * @param actcode
	 * @return
	 * @throws Exception
	 */
	public int active(String actcode) throws Exception; 
	
	/**
	 * 登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int loginByUserName(User user) throws Exception; 
	
	public int loginByEmail(User user) throws Exception; 
	
	/**
	 * 获取用户信息
	 * @param ermail
	 * @return
	 * @throws Exception
	 */
	public User getInfoByEmail(String email) throws Exception;
	public User getInfoByUserName(String username) throws Exception;
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int updateInfo (User user) throws Exception; 
	
	
	/**
	 * 更新密码
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public int updataPassword(User user) throws Exception;
	
	/**
	 * 自动登录
	 * @param username
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User autoLogin(String username,String email,String password)throws Exception;

} 
