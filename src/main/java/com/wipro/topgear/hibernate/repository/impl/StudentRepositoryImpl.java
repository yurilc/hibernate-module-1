package com.wipro.topgear.hibernate.repository.impl;

import com.wipro.topgear.hibernate.domain.Student;
import com.wipro.topgear.hibernate.repository.AbstractRepository;
import com.wipro.topgear.hibernate.repository.StudentRepository;
import org.hibernate.Session;

public class StudentRepositoryImpl extends AbstractRepository<Student, Long> implements StudentRepository {
    public StudentRepositoryImpl(Session session) {
        super(Student.class, session);
    }
}
