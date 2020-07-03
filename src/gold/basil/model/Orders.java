package gold.basil.model;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月30日 下午1:52:10 
*/
public class Orders extends OrdetItem{
	private int id;
	private int user_id;
	private double money;
	private String receiveName;
	private String receivePhone;
	private String receiveAddr;
	private String orderTime;
	private int state;
	private String order_id;
	private Book book;
	
	public Orders() {}
	
	public Orders(int id, int user_id, double money, String receiveName, String receivePhone, String receiveAddr,String orderTime) {
		this.id = id;
		this.user_id = user_id;
		this.money = money;
		this.receiveName = receiveName;
		this.receivePhone = receivePhone;
		this.receiveAddr = receiveAddr;
		this.setOrderTime(orderTime);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getReceivePhone() {
		return receivePhone;
	}

	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}

	public String getReceiveAddr() {
		return receiveAddr;
	}

	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}
	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", user_id=" + user_id + ", money=" + money + ", receiveName=" + receiveName
				+ ", receivePhone=" + receivePhone + ", receiveAddr=" + receiveAddr + ", orderTime=" + orderTime
				+ ", state=" + state + ", order_id=" + order_id + ", book=" + book + "]";
	}
	








	
	
	
}
