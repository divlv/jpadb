package lv.div.jpadb.beans.service;

import lv.div.jpadb.domain.DemoData;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * This bean should be in the context of EJB Container (@Stateless),
 * if we want to use all the benefits from JTA (e.g. rollback on exception)
 */
@Stateless
public class RollbackBean {

    @EJB
    GenericService genericService;

    public void tryToSave() {
        DemoData demoData = new DemoData();

        demoData.setName("This should not be saved");

        genericService.save(demoData);

        // Throw exception here and see if this new "DemoData" object was saved...?
        throw new RuntimeException("HE-E-ELP! My hair is on fire!!!");
    }

}
