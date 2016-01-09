package com.ethlo.persistence.tools.eclipselink.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ethlo.persistence.tools.eclipselink.test.model.IpEntry;

public interface IpRepository extends JpaRepository<IpEntry, Integer>
{

}
