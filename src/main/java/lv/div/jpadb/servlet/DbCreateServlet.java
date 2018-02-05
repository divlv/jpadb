package lv.div.jpadb.servlet;

import lv.div.jpadb.beans.service.CreateBean;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * CRUD Operations demo: CREATE
 * After successful application deployment
 * it should be available at "http://localhost:8080/jpadb/create"
 */
public class DbCreateServlet extends HttpServlet {

    @EJB
    CreateBean createBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();
        createBean.saveData();
        out.print("Data saved. Current time is: " + new Date());
    }
}
