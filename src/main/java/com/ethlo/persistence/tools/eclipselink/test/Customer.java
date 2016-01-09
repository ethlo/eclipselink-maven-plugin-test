package com.ethlo.persistence.tools.eclipselink.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Customer
{
	@Id
	private Integer id;
	
	@NotNull
	@Column(nullable=false)
	private String name;
	
	@Column
	private int age;
}
