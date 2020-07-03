package gold.basil.model;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月24日 上午8:05:03 
*/
public class User {
	private int id;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String email;
	private String phone;
	private String role;
	private int state;
	private String registTime;
	private String actcode;
	
	public User() {}
	


	public User(int id, String username, String password, String name, String sex, String email, String phone,
			String role, int state, String registTime) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.state = state;
		this.registTime = registTime;
	}

	public User( String username, String password, String name, String email, String phone,String actcode) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.actcode = actcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRegistTime() {
		return registTime;
	}

	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	
	public String getActcode() {
		return actcode;
	}

	public void setActcode(String actcode) {
		this.actcode = actcode;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", email=" + email + ", phone=" + phone + ", role=" + role + ", state=" + state
				+ ", registTime=" + registTime + "]";
	}

	
	
	
	
	
}
