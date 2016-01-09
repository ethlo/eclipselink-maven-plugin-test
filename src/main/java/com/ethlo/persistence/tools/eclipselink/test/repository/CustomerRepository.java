package com.ethlo.persistence.tools.eclipselink.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethlo.persistence.tools.eclipselink.test.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
}