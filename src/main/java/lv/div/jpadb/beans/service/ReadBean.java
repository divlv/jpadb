package lv.div.jpadb.beans.service;

import lv.div.jpadb.domain.DemoData;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ReadBean {

    @EJB
    GenericService genericService;

    public List<DemoData> readData() {
        final List<DemoData> list = genericService.list();
        return list;
    }

}
