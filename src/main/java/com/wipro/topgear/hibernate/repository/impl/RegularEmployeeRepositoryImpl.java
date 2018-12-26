package com.wipro.topgear.hibernate.repository.impl;

import com.wipro.topgear.hibernate.domain.RegularEmployee;
import com.wipro.topgear.hibernate.repository.AbstractRepository;
import com.wipro.topgear.hibernate.repository.RegularEmployeeRepository;
import org.hibernate.Session;

public class RegularEmployeeRepositoryImpl extends AbstractRepository<RegularEmployee, Long> implements RegularEmployeeRepository {
    public RegularEmployeeRepositoryImpl(Session session) {
        super(RegularEmployee.class, session);
    }
}
