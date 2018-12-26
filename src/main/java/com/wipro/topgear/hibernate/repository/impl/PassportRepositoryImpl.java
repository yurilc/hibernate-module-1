package com.wipro.topgear.hibernate.repository.impl;

import com.wipro.topgear.hibernate.domain.Passport;
import com.wipro.topgear.hibernate.repository.AbstractRepository;
import com.wipro.topgear.hibernate.repository.PassportRepository;
import org.hibernate.Session;

public class PassportRepositoryImpl extends AbstractRepository<Passport, Long> implements PassportRepository {
    public PassportRepositoryImpl(Session session) {
        super(Passport.class, session);
    }
}
