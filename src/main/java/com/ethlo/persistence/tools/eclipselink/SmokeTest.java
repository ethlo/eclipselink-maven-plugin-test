package com.ethlo.persistence.tools.eclipselink;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ethlo.persistence.tools.eclipselink.test.model.Customer;
import com.ethlo.persistence.tools.eclipselink.test.model.IpEntry;
import com.ethlo.persistence.tools.eclipselink.test.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestCfg.class)
public class SmokeTest
{
	@Autowired
	private CustomerRepository customerRepo;
	
	@Test
	public void testInit()
	{
		
	}
	
	@Test
	public void addCustomer()
	{
		final Customer c = new Customer();
		c.setName("John Doe");
		c.addIp(new IpEntry("204.54.12.14"));
		customerRepo.save(c);
	}
}
