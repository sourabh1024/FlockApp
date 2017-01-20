package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sourabh.su on 14/01/17.
 */
public class Widgets extends HttpServlet {

    protected void getResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getResponse(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getResponse(req, resp);
    }
}
