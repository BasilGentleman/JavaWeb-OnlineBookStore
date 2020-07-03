package gold.basil.service;

import java.util.List;

import gold.basil.model.Book;
import gold.basil.model.Page;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月23日 下午7:39:14 
*/
public interface BookService {
	//获取销量前八的书
	public List<Book> getHostSalesBooks() throws Exception;
	
	//搜索
	public List<Book> getNameBooks(String parameter) throws Exception;
	public List<Book> getNameBooks(String parameter,Integer currPageNo,Integer pageSize) throws Exception ;
	
	//按类别查询
	public List<Book> getCategoryBooks(String category) throws Exception;
	
	//获取类别
	public List<String> getCategory() throws Exception;
	
	//按id查询书籍信息
	public Book getBook(int id) throws Exception;
}
