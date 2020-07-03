package gold.basil.model;

import java.io.Serializable;
import java.util.List;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月24日 下午7:02:13
* @描述 分页 
*/
public class Page2 implements Serializable {
	private Integer totalCount;	//总记录数
	private Integer pageSize = 12; //页面容量
	private Integer totalPageCount; //总页数 = 总记录数/页面容量
	private Integer currPageNo = 1;//当前页
	
	private List<Book> bookList;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		if(totalCount !=0) {
			//计算总页数
			this.totalPageCount =(totalCount % pageSize) == 0?  (totalCount / pageSize) : (totalCount / pageSize + 1);
		}
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public Integer getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(Integer currPageNo) {
		this.currPageNo = currPageNo;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
}
