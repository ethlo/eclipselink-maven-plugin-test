package com.ethlo.persistence.tools.eclipselink.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="customer")
public class Customer
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(nullable=false)
	private String name;
	
	@Column
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpEntry> ips = new ArrayList<>();

	public void setName(String name)
	{
		this.name = name;
	}

	public void addIp(IpEntry ipEntry)
	{
		this.ips.add(ipEntry);
	}
}
