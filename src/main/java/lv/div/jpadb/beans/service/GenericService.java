package lv.div.jpadb.beans.service;

import lv.div.jpadb.common.DatabaseConnection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Common database methods
 */
@Stateless
public class GenericService {

    @Inject
    @DatabaseConnection
    private EntityManager em;

    public List list() {
        final Query namedQuery = em.createNamedQuery("DemoData.list");
        namedQuery.setParameter("id", -10L);
        return namedQuery.getResultList();
    }

    public void update(Object cl) {
        em.merge(cl);
    }

    public void save(Object cl) {
        em.persist(cl);
    }

    public void deleteByQuery() {
        final Query deleteQuery = em.createNamedQuery("DemoData.delete");
        deleteQuery.executeUpdate();
    }



    public Object find(Class c, Long key) {
        return em.find(c, key);
    }

}
