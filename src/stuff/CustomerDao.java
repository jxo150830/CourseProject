package stuff;

import java.util.List;

public interface CustomerDao {
	public int register(Customer c);

	public Customer validateCustomer(Login login);
	
	public Customer getCustomer(int id);
	
	public List<Customer> getCustomers();
	
	public List<Customer> getCustomers(int enterpriseId);
	
	public String getEnterpriseName(int enterpriseId);
	
	public int changeSettings(int id, String name, String username, String password, String color, String about);
	
	public int incrementLevel(int id);
	
}