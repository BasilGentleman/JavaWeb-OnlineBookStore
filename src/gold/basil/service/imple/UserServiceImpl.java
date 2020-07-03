package gold.basil.service.imple;

import gold.basil.dao.UserDao;
import gold.basil.dao.imple.UserDaoImple;
import gold.basil.model.User;
import gold.basil.service.UserService;
import gold.basil.utils.MailUtil;




/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月24日 上午8:17:42 
*/
public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImple();
	
	/**
	 * 注册
	 * 
	 * @param user
	 * @param piccode
	 * @param checkCode
	 * @return
	 */
	@Override
	public int registerUser(User user, String piccode, String checkCode) {
		int result = 0;

		// 判断验证码是否正确
		boolean b = CheckCode(piccode, checkCode);
		if (b) {
			// 判断用户是否存在
			try {
				if (userDao.findUser(user.getUsername(), user.getEmail()) != null) {
					return 0; // 返回0 已存在用户
				} else {
					// 插入用户数据
					result = userDao.register(user);
					if (result == 1) { // 插入成功发送邮件
						MailUtil.sendMail(user.getEmail(), user.getActcode());

					} else {
						return 0;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			result = 3; // 验证码有误
		}

		return result;
	}
		
	
	/**
	 * 激活
	 * @param actcode
	 * @return
	 * @throws Exception
	 */
	@Override
	public int active(String actcode) throws Exception {
		int result = userDao.active(actcode);
		return result;
	}
	
	
	/**
	 * 验证码的判断
	 * piccode ： 为ImageServlet存入session域中的值
	 * checkCode ： 为用户输入的值
	 * @param piccode
	 * @param checkCode
	 * @return
	 */
	
	public static boolean CheckCode(String piccode, String checkCode) {
		checkCode = checkCode.toUpperCase();  //将输入的验证码全部转为大写
		
		if(piccode.equals(checkCode)) {
			return true;    //输入的验证码与随机生成的验证码一致
		} else {
			return false;
		}
	}
	
	
	@Override
	public int loginByEmail(User user, String piccode, String checkCode) throws Exception {
		int result = 0;
		// 判断验证码是否正确
		boolean b = CheckCode(piccode, checkCode);
		if (b) {
			result = userDao.loginByEmail(user);
			if(result == 1){
				return 1;
			} else {
				MailUtil.sendMail(user.getEmail(), user.getActcode());   //未激活发送激活连接
			}
		} else{
			result = 3; // 验证码有误
		}
		return result;
		
		
	}

	@Override
	public int loginByUserName(User user, String piccode, String checkCode) throws Exception {
		int result = 0;
		// 判断验证码是否正确
		boolean b = CheckCode(piccode, checkCode);
		if (b) {
			result = userDao.loginByUserName(user);
			if(result == 1){
				return 1;
			}
		} else{
			result = 3; // 验证码有误
		}
		return result;
		
		
	}

	/**
	 * 获取登录信息
	 */
	@Override
	public User getInfoByEmail(String email) throws Exception {
		User user = userDao.getInfoByEmail(email);
		return user;
	}


	@Override
	public User getInfoByUserName(String username) throws Exception {
		// TODO 自动生成的方法存根
		User user = userDao.getInfoByUserName(username);
		return user;
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public int updateInfo(User user) throws Exception {
		int result = 0;
		result = userDao.updateInfo(user);
		return result;
	}

	/**
	 * 更新用户密码
	 */
	@Override
	public int updatePassword(User user) throws Exception {
		int result = 0 ;
		result = userDao.updataPassword(user);
		return result;
	}

	/**
	 * 自动登录
	 */
	@Override
	public User aotuLogin(String login,String password) throws Exception {
		return userDao.autoLogin(login, login, password);
	}


}
