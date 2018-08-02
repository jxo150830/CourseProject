package test;

import org.junit.*;

import stuff.Customer;
import stuff.CustomerDao;
import stuff.CustomerDaoImpl;

public class CustomerTest {
	Customer c = new Customer();
	
	@Before
	public void createCustomer() {
		// fill values of c
		c.setId(1);
		c.setName("Smith");
		c.setUsername("asdf");
		c.setPassword("asdf");
		c.setLevel(1);
		c.setColor("00ff00");
		c.setAbout("This user has nothing to say about themselves.");
		c.setIsEnterprise(0);
		c.setEnterprise(1);
		
		Assume.assumeTrue(c.getId() == 1);
		Assume.assumeTrue(c.getName().equals(""));
		Assume.assumeTrue(c.getUsername().equals(""));
		Assume.assumeTrue(c.getPassword().equals(""));
		Assume.assumeTrue(c.getLevel() == 1);
		Assume.assumeTrue(c.getColor().equals(""));
		Assume.assumeTrue(c.getAbout().equals(""));
		Assume.assumeTrue(c.getIsEnterprise() == 0);
		Assume.assumeTrue(c.getEnterprise() == 1);
	}
	
	@Test
	public void testRegister() {
		// register c
		CustomerDao customerDao = new CustomerDaoImpl();
		customerDao.register(c);

		// check if c has been registered
		Customer d = customerDao.getCustomer(c.getId());
		Assert.assertTrue(d.equals(c));
	}
}
