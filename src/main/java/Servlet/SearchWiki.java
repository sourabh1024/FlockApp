package Servlet;

import beans.WikiBean;
import services.SearchWikiUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sourabh.su on 23/01/17.
 */
public class SearchWiki extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Query Recieved");
        WikiBean wikiBean = new WikiBean(req);
        String esResult = new SearchWikiUtil().searchWiki(wikiBean.getKeyword(), wikiBean.getTeamName());
        PrintWriter out = resp.getWriter();
        resp.setStatus(200);
        resp.setContentType("application/json");
        out.print(esResult);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
