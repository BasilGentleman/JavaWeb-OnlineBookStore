package gold.basil.model;

import java.io.Serializable;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月27日 下午5:52:54 
*/
public class ShopCart  {
	private int id;
	private int user_id;
	private int book_id;
	private int amount;
	private double money;
	private Book book;
	public ShopCart() {}
	
	
	
	public ShopCart(int user_id, int book_id, int amount, double money) {
		this.user_id = user_id;
		this.book_id = book_id;
		this.amount = amount;
		this.money = money;
	}



	public ShopCart(int user_id, int book_id, int amount, double money, Book book) {
		this.user_id = user_id;
		this.book_id = book_id;
		this.amount = amount;
		this.money = money;
		this.book = book;
	}



	public ShopCart(int id, int user_id, int book_id, int amount, double money) {
	
		this.id = id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.amount = amount;
		this.money = money;
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
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		
		
		
		this.money = money;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	@Override
	public String toString() {
		return "ShopCart [id=" + id + ", user_id=" + user_id + ", book_id=" + book_id + ", amount=" + amount
				+ ", money=" + money + ", book=" + book + "]";
	}
	
	
}
