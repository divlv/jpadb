package lv.div.jpadb.beans;

import lv.div.jpadb.common.DatabaseConnection;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * CDI Resources producer.
 */
public class Resources implements Serializable {

    private static final long serialVersionUID = 1295657352028521544L;

    @PersistenceContext(unitName = "MYDS1")
    private EntityManager entityManager1;

    public Resources() {
    }

    /**
     * Producer of particular Entity Manager
     *
     * @return
     */
    @Produces
    @RequestScoped
    @DatabaseConnection
    public EntityManager entityManagerSelector() {
        int a = 1;
        // There can be any logic to switch between several Entity managers, if any:
        if (a == 1) {
            return entityManager1;
        } else {
            return null;
        }

    }

}