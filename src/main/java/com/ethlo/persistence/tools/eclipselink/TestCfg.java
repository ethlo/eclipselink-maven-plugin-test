package com.ethlo.persistence.tools.eclipselink;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.ethlo.persistence.tools.eclipselink.test.Customer;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses=Customer.class)
@EntityScan(basePackageClasses=Customer.class)
public class TestCfg
{

}
