package com.wipro.topgear.hibernate.repository.impl;

import com.wipro.topgear.hibernate.domain.Department;
import com.wipro.topgear.hibernate.repository.AbstractRepository;
import com.wipro.topgear.hibernate.repository.DepartmentRepository;
import org.hibernate.Session;

public class DepartmentRepositoryImpl extends AbstractRepository<Department, Long> implements DepartmentRepository {
    public DepartmentRepositoryImpl(Session session) {
        super(Department.class, session);
    }
}
