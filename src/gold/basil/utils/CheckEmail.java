package gold.basil.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月24日 上午11:35:49 
*/
public class CheckEmail {
	
	/***
	 * 验证邮箱
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email){
        boolean flag = false;
        try{
                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                Pattern regex = Pattern.compile(check);
                Matcher matcher = regex.matcher(email);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
}
