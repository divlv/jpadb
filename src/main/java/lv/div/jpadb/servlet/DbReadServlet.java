package lv.div.jpadb.servlet;

import lv.div.jpadb.beans.service.ReadBean;
import lv.div.jpadb.domain.DemoData;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * CRUD Operations demo: READ
 * After successful application deployment
 * it should be available at "http://localhost:8080/jpadb/read"
 */
public class DbReadServlet extends HttpServlet {

    @EJB
    ReadBean readBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();
        out.print("<b>JPADB</b> demo application works!<br />");
        out.print("Current time is: " + new Date() + "<br /><br />");

        final List<DemoData> list = readBean.readData();
        for (DemoData user : list) {
            out.print("User id = " + user.getId() + ", User name = " + user.getName() + "<br /><br />");
        }


    }
}
