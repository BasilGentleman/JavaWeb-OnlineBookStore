package gold.basil.model;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月23日 上午8:25:55 
*/
public class Book {
	private int id;
	private String name;
	private double price;
	private String category;
	private String imgurl;
	private String description;
	private int sales;
	
	
	public Book() {}
	
	public Book(int id, String name, double price, String category, String imgurl, String description, int sales) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.imgurl = imgurl;
		this.description = description;
		this.sales = sales;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", imgurl="
				+ imgurl + ", description=" + description + ", sales=" + sales + "]";
	}
	
	
	
	
}
