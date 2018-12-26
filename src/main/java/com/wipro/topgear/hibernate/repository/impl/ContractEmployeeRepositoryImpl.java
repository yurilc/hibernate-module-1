package com.wipro.topgear.hibernate.repository.impl;

import com.wipro.topgear.hibernate.domain.ContractEmployee;
import com.wipro.topgear.hibernate.repository.AbstractRepository;
import com.wipro.topgear.hibernate.repository.ContractEmployeeRepository;
import org.hibernate.Session;

public class ContractEmployeeRepositoryImpl extends AbstractRepository<ContractEmployee, Long> implements ContractEmployeeRepository {
    public ContractEmployeeRepositoryImpl(Session session) {
        super(ContractEmployee.class, session);
    }
}
