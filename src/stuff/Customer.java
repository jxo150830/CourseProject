package stuff;

public class Customer {
	private int id;
	private String name;
	private String username;
	private String password;
	private int level;
	private String color;
	private String about;
	private int isEnterprise;
	private int enterprise;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public int getLevel() { return level; }
	public void setLevel(int level) { this.level = level; }
	
	public String getColor() { return color; }
	public void setColor(String color) { this.color = color; }
	
	public String getAbout() { return about; }
	public void setAbout(String about) { this.about = about; }

	public int getIsEnterprise() { return isEnterprise; }
	public void setIsEnterprise(int isEnterprise) { this.isEnterprise = isEnterprise; }

	public int getEnterprise() { return enterprise; }
	public void setEnterprise(int enterprise) { this.enterprise = enterprise; }
}