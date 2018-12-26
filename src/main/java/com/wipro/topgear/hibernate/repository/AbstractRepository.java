package com.wipro.topgear.hibernate.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractRepository<E, ID extends Serializable> implements Repository<E, ID> {
    private static final Logger log = LogManager.getLogger(AbstractRepository.class);

    private final Class<E> entityType;
    private final Session session;

    public AbstractRepository(Class<E> entityType, Session session) {
        this.entityType = entityType;
        this.session = session;
    }

    @Override
    public E save(E entity) {
        Transaction tx = session.beginTransaction();
        try {
            session.persist(entity);
            tx.commit();
            return entity;
        } catch (Exception e) {
            log.error("Error while trying to save entity", e);
            tx.rollback();
        }
        return null;
    }

    @Override
    public void delete(ID id) {
        Transaction tx = session.beginTransaction();
        try {
            E found = session.find(entityType, id);
            if(found != null) {
                session.delete(found);
            }
            tx.commit();
        } catch (Exception e) {
            log.error("Error while trying to delete entity", e);
            tx.rollback();
        }
    }

    @Override
    public E update(E entity) {
        E updated = null;
        Transaction tx = session.beginTransaction();
        try {
            updated = (E) session.merge(entity);
            tx.commit();
        } catch (Exception e) {
            log.error("Error while trying to update entity", e);
            tx.rollback();
        }
        return updated;
    }

    @Override
    public E findById(ID id) {
        return session.find(entityType, id);
    }

    @Override
    public List<E> findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityType);
        return (List<E>) criteria.getExecutableCriteria(session).list();
    }

    public Class<E> getEntityType() {
        return entityType;
    }

    public Session getSession() {
        return session;
    }
}
