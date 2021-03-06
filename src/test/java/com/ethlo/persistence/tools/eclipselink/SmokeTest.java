package com.ethlo.persistence.tools.eclipselink;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ethlo.persistence.tools.eclipselink.test.model.Customer;
import com.ethlo.persistence.tools.eclipselink.test.model.IpEntry;
import com.ethlo.persistence.tools.eclipselink.test.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestCfg.class)
public class SmokeTest
{
	@Autowired
	private CustomerRepository customerRepo;
	
	@Test
	public void testInit()
	{
		// Just to check initialization
	}
	
	@Test
	public void addCustomerWithSingleIpEntryAndVerify()
	{
		final Customer c = new Customer();
		c.setName("John Doe");
		c.addIp(new IpEntry("204.54.12.14"));
		customerRepo.save(c);
		
		final List<Customer> res = customerRepo.findAll();
		assertThat(res).hasSize(1);
		assertThat(c.getIps().get(0).getIp()).isEqualTo("204.54.12.14");
	}
}
