package lv.div.jpadb.servlet;

import lv.div.jpadb.beans.service.DeleteBean;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * CRUD Operations demo: UPDATE
 * After successful application deployment
 * it should be available at "http://localhost:8080/jpadb/update"
 */
public class DbDeleteServlet extends HttpServlet {

    @EJB
    DeleteBean deleteBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();

        deleteBean.deleteData();

        out.print("Data deleted. Current time is: " + new Date());
        out.flush();

    }
}
