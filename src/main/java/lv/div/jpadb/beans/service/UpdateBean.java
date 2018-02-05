package lv.div.jpadb.beans.service;

import lv.div.jpadb.domain.DemoData;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UpdateBean {

    @EJB
    GenericService genericService;

    public void updateData() {
        // Just a dummy value to update:
        final long randomValue = Math.round(Math.random() * 999999);
        final DemoData demoData = (DemoData) genericService.find(DemoData.class, 1L);
        demoData.setName(String.valueOf(randomValue));
        genericService.update(demoData);
    }

}
