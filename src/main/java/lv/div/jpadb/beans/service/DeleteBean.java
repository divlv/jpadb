package lv.div.jpadb.beans.service;

import lv.div.jpadb.domain.DemoData;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DeleteBean {

    @EJB
    GenericService genericService;

    public void deleteData() {
        genericService.deleteByQuery();
    }

}
