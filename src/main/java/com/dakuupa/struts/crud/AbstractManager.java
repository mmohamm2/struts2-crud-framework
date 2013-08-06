package com.dakuupa.struts.crud;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author etwilliams
 * modified AbstractFacade from NetBeans autogeneration
 */
public abstract class AbstractManager<T> {
    protected Class<T> entityClass;
    protected String entityName;

    public AbstractManager(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.entityName = entityClass.getSimpleName();
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public T read(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public List<T> readAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
