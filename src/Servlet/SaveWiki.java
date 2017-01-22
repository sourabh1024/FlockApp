package Servlet;

import beans.WikiDocument;
import services.CreateWiki;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class SaveWiki extends HttpServlet {

    private CreateWiki createWiki;
    private WikiDocument wikiDocument;

    protected void getResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        wikiDocument = new WikiDocument();

        createWiki = CreateWiki.getInstance();
        Boolean status = createWiki.addDocumentToDataBase(wikiDocument);
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
