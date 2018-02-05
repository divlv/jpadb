package lv.div.jpadb.beans.service;

import lv.div.jpadb.domain.DemoData;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

@Stateless
public class CreateBean {

    @EJB
    GenericService genericService;

    public void saveData() {
        DemoData demoData = new DemoData();

        // Just a dummy value to save:
        final long randomValue = Math.round(Math.random() * 999999);
        demoData.setName(String.valueOf(randomValue));

        genericService.save(demoData);
    }

}
