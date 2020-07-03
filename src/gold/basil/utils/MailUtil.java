package gold.basil.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Enumeration;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/** 
* @author 作者  Basil: 
* @version 1.0
* @创建时间 2020年6月18日 下午4:49:43 
*/
public class MailUtil {

	/**
	 * 发送邮件的方法： 发送一封激活邮件
	 * @param mail 收件人邮箱
	 * @param actcode  收件人激活码
	 */
	public static void sendMail(String email, String actcode) throws IOException {
		//创建session对象
		//创建 邮件对象
	
		String from = "xxxxx";// 发件人电子邮箱
		String host ="smtp.qq.com";
		final String authorizationCode = "xxxxa";  //授权码
		Properties properties = System.getProperties();// 获取系统属性
		properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
		properties.setProperty("mail.smtp.auth", "true");// 打开认证

		
		 
		try {
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);
			
			// 1.获取默认session对象
			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("xxxxxxxx",authorizationCode); // 发件人邮箱账号、授权码
				}
			});
			
			// 2.创建邮件对象
			Message message = new MimeMessage(session);
			// 2.1设置发件人
			message.setFrom(new InternetAddress(from));
			// 2.2设置接收人
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			// 2.3设置邮件主题
			message.setSubject("账号激活");
			String content = "<html><head></head><body><h1>请点击以下链接激活注册账号</h1><h3><a href='http://localhost:8080/BookStore/ActiveServlet?code="
					+ actcode + "'>http://localhost:8080/BookStore/active?actcode=" + actcode
					+ "</href></h3></body></html>";
			message.setContent(content, "text/html;charset=UTF-8");
			// 3.发送邮件
			Transport.send(message);
			System.out.println("激活邮件成功发送!");

		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		

		
	}
	
}

