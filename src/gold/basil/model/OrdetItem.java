package gold.basil.model;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月29日 下午9:17:44 
*/
public class OrdetItem{
	private int id;
	private String order_id;
	private int book_id;
	private int num;
	
	private ShopCart shopCartl;

	
	
	public OrdetItem() {
	}

	public OrdetItem(int id, String order_id, int book_id, int num, ShopCart shopCartl) {
		this.id = id;
		this.order_id = order_id;
		this.book_id = book_id;
		this.num = num;
		this.shopCartl = shopCartl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ShopCart getShopCartl() {
		return shopCartl;
	}

	public void setShopCartl(ShopCart shopCartl) {
		this.shopCartl = shopCartl;
	}

	@Override
	public String toString() {
		return "OrdetItem [id=" + id + ", order_id=" + order_id + ", book_id=" + book_id + ", num=" + num
				+ ", shopCartl=" + shopCartl + "]";
	}
	
	
	
}
