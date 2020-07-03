package gold.basil.dao;

import java.util.List;

import gold.basil.model.Book;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月23日 上午9:43:17 
* @描述	图书功能接口
*/
public interface BookDao extends Dao {
	
	//获取销量最多的8本图书
	public List<Book> findHostSales() throws Exception;
	
	//高级搜索
	public List<Book> search(String parameter) throws Exception;

	//高级搜索,分页显示数据
	public List<Book> search(String parameter,Integer startIndex,Integer pageSize) throws Exception;
	
	//返回记录数
	public int getCountBooks(String name) throws Exception;
	
	//分类查询
	public List<Book> findCategory(String category) throws Exception;
	
	//获取类别
	public List<String> getCategory() throws Exception;
	
	//按id查询书籍信息
	public Book getBook(int id ) throws Exception;
	
}
