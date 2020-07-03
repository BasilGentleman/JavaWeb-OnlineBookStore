package gold.basil.service;

import gold.basil.model.User;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月23日 下午7:35:29 
*/
public interface UserService {
	//注册接口
	public int registerUser(User user, String piccode, String checkCode);
	//激活几口
	public int active(String actcode) throws Exception;
	//邮箱登录
	public int loginByEmail(User user, String piccode, String checkCode) throws Exception;
	//用户名登录
	public int loginByUserName(User user, String piccode, String checkCode) throws Exception;
	//获取用户信息
	public User getInfoByEmail(String email) throws Exception;
	//获取用户信息
	public User getInfoByUserName(String username) throws Exception;
	//更新用户信息
	public int updateInfo(User user) throws Exception;
	//更新密码
	public int updatePassword(User user) throws Exception;
	//验证自动登录
	public User aotuLogin(String login,String password) throws Exception;
	
}
