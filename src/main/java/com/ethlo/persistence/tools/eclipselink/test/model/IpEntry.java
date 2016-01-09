package com.ethlo.persistence.tools.eclipselink.test.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ethlo.persistence.tools.eclipselink.test.converter.Ip4Converter;

@Entity
@Table(name = "ips")
public class IpEntry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ip4")
    @Convert(converter = Ip4Converter.class)
    private String ip4;

    /**
     * JPA requirement
     */
    protected IpEntry()
    {
    }
    
    public IpEntry(String dotIp)
    {
    	this.ip4 = dotIp;
    }
}
