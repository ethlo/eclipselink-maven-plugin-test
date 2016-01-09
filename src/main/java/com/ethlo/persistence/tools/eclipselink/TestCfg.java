package com.ethlo.persistence.tools.eclipselink;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

import com.ethlo.persistence.tools.eclipselink.test.converter.Ip4Converter;
import com.ethlo.persistence.tools.eclipselink.test.model.Customer;
import com.ethlo.persistence.tools.eclipselink.test.repository.CustomerRepository;

@EnableAutoConfiguration
@EntityScan(basePackageClasses = {Ip4Converter.class, Customer.class})
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
public class TestCfg extends JpaBaseConfiguration
{
	@Override
	protected AbstractJpaVendorAdapter createJpaVendorAdapter()
	{
		return new EclipseLinkJpaVendorAdapter();
	}

	@Override
	protected Map<String, Object> getVendorProperties()
	{
		final Map<String, Object> retVal = new TreeMap<>();
		retVal.put(PersistenceUnitProperties.WEAVING, "static");
		retVal.put(PersistenceUnitProperties.DDL_GENERATION, "create-tables");
		return retVal;
	}
}
