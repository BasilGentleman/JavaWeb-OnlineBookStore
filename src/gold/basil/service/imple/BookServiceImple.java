package gold.basil.service.imple;

import java.util.List;

import gold.basil.dao.BookDao;
import gold.basil.dao.imple.BookDaoImple;
import gold.basil.model.Book;
import gold.basil.model.Page;
import gold.basil.service.BookService;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月23日 上午10:08:40 
* @描述 book业务处理层
*/
public class BookServiceImple implements BookService{
	private BookDao bookDao = new BookDaoImple();
	private List<Book> booklist = null;
	
	
	/**
	 * 获取销量前8的图书
	 * @return booklist
	 * @throws Exception
	 */
	@Override
	public List<Book> getHostSalesBooks() throws Exception {
		
		//调用dao获取数据
		booklist = bookDao.findHostSales();
		
		return booklist;
	}
	
	
	/**
	 * 搜索
	 */
	@Override
	public List<Book> getNameBooks(String parameter) throws Exception {
		booklist = bookDao.search(parameter);
		return booklist;
	}
	
	//搜索  分页
	@Override
	public List<Book> getNameBooks(String parameter,Integer currPageNo,Integer pageSize) throws Exception {
//		int startIndex = bookDao.getCountBooks(parameter) / pageSize;
//		List<Book> booklist = bookDao.search(parameter, startIndex, pageSize);
		return booklist;
	}

	/**
	 * 按类别查询书籍
	 */
	@Override
	public List<Book> getCategoryBooks(String category) throws Exception {
		//调用dao获取数据
		booklist = bookDao.findCategory(category);
		return booklist;
	}

	/**
	 * 获取类别
	 */
	@Override
	public List<String> getCategory() throws Exception {
		return bookDao.getCategory();
	}

	/**
	 * 按id查询书籍信息
	 */
	@Override
	public Book getBook(int id) throws Exception {
		return bookDao.getBook(id);
	}
	
	
	
	
	
}
