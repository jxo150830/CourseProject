package stuff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;

public class CustomerDaoImpl implements CustomerDao {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public int register(Customer c) {
		int status = 0;
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("INSERT INTO customer(name, username, password, is_enterprise, enterprise) VALUES (?,?,?,?,?)");
			ps.setString(1, c.getName());
			ps.setString(2, c.getUsername());
			ps.setString(3, c.getPassword());
			ps.setInt(4, c.getIsEnterprise());
			ps.setInt(5, c.getEnterprise());
			status = ps.executeUpdate();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public Customer validateCustomer(Login login) {
		Customer c = new Customer();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("SELECT * FROM customer WHERE username=? AND password=?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setUsername(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setLevel(rs.getInt(5));
				c.setColor(rs.getString(6));
				c.setAbout(rs.getString(7));
				c.setIsEnterprise(rs.getInt(8));
				c.setEnterprise(rs.getInt(9));
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return c;
	}
	
	@Override
	public Customer getCustomer(int id) {
		Customer c = new Customer();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("SELECT * FROM customer WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setUsername(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setLevel(rs.getInt(5));
				c.setColor(rs.getString(6));
				c.setAbout(rs.getString(7));
				c.setIsEnterprise(rs.getInt(8));
				c.setEnterprise(rs.getInt(9));
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return c;
	}
	
	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("SELECT * FROM customer");

			ResultSet rs = ps.executeQuery();
			for (int i = 0; rs.next(); i++) {
				customers.add(new Customer());
				customers.get(i).setId(rs.getInt(1));
				customers.get(i).setName(rs.getString(2));
				customers.get(i).setUsername(rs.getString(3));
				customers.get(i).setPassword(rs.getString(4));
				customers.get(i).setLevel(rs.getInt(5));
				customers.get(i).setColor(rs.getString(6));
				customers.get(i).setAbout(rs.getString(7));
				customers.get(i).setIsEnterprise(rs.getInt(8));
				customers.get(i).setEnterprise(rs.getInt(9));
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return customers;
	}
	
	@Override
	public List<Customer> getCustomers(int enterpriseId) {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("SELECT * FROM customer WHERE enterprise=?");
			ps.setInt(1, enterpriseId);

			ResultSet rs = ps.executeQuery();
			for (int i = 0; rs.next(); i++) {
				customers.add(new Customer());
				customers.get(i).setId(rs.getInt(1));
				customers.get(i).setName(rs.getString(2));
				customers.get(i).setUsername(rs.getString(3));
				customers.get(i).setPassword(rs.getString(4));
				customers.get(i).setLevel(rs.getInt(5));
				customers.get(i).setColor(rs.getString(6));
				customers.get(i).setAbout(rs.getString(7));
				customers.get(i).setIsEnterprise(rs.getInt(8));
				customers.get(i).setEnterprise(rs.getInt(9));
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return customers;
	}
	
	@Override
	public String getEnterpriseName(int enterpriseId) {
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("SELECT * FROM customer WHERE id=? LIMIT 1");
			ps.setInt(1, enterpriseId);

			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getString(2);
			conn.close();
			return name;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return "";
	}
	
	@Override
	public int changeSettings(int id, String name, String username, String password, String color, String about) {
		int status = 0;
		try {
			conn = db.getConnection();
			
			ps = conn.prepareStatement("UPDATE customer SET name=?, username=?, password=?, color=?, about=? WHERE id=?");
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, color);
			ps.setString(5, about);
			ps.setInt(6, id);
			status = ps.executeUpdate();
			
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	@Override
	public int incrementLevel(int id) {
		int status = 0;
		Customer c = getCustomer(id);
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("UPDATE customer SET level=? WHERE id=?");
			ps.setInt(1, c.getLevel() + 1);
			ps.setInt(2, id);
			status = ps.executeUpdate();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
}