package com.wipro.topgear.hibernate.repository.impl;

import com.wipro.topgear.hibernate.domain.Course;
import com.wipro.topgear.hibernate.repository.AbstractRepository;
import com.wipro.topgear.hibernate.repository.CourseRepository;
import org.hibernate.Session;

public class CourseRepositoryImpl extends AbstractRepository<Course, Long> implements CourseRepository {
    public CourseRepositoryImpl(Session session) {
        super(Course.class, session);
    }
}
