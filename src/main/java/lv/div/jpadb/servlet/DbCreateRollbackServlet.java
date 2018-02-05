package lv.div.jpadb.servlet;

import lv.div.jpadb.beans.service.RollbackBean;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CRUD Operations demo: CREATE, but rolled back, due to exception
 * After successful application deployment
 * it should be available at "http://localhost:8080/jpadb/createrollback"
 */
public class DbCreateRollbackServlet extends HttpServlet {

    @EJB
    RollbackBean rollbackBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        rollbackBean.tryToSave();
    }
}
