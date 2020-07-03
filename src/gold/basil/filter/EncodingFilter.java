package gold.basil.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月22日 上午11:41:43 
* @描述 处理全局中文乱码
*/
@WebFilter(filterName = "EncodingFilter" ,  urlPatterns = {"/*"})
public class EncodingFilter extends HttpFilter{
	private static final long serialVersionUID = -3273677381790044474L;
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//处理中文乱码问题
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		
		//把请求转发至下一个过滤器或者资源
		chain.doFilter(req, res);
		
	}

}
