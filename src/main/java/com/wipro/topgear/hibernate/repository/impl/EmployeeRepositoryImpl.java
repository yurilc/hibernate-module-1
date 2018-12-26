package com.wipro.topgear.hibernate.repository.impl;

import com.wipro.topgear.hibernate.domain.Employee;
import com.wipro.topgear.hibernate.repository.AbstractRepository;
import com.wipro.topgear.hibernate.repository.EmployeeRepository;
import org.hibernate.Session;

public class EmployeeRepositoryImpl extends AbstractRepository<Employee, Long> implements EmployeeRepository {
    public EmployeeRepositoryImpl(Session session) {
        super(Employee.class, session);
    }
}
