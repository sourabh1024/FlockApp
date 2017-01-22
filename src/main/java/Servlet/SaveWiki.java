package Servlet;

import beans.RequestParams;
import beans.WikiBean;
import beans.WikiDocument;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import services.CreateWiki;
import services.RegisterUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by sourabh.su on 22/01/17.
 */
public class SaveWiki extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WikiBean wikiBean = new WikiBean(req);
        System.out.println("done!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WikiBean wikiBean = new WikiBean(req);
        CreateWiki createWiki = CreateWiki.getInstance();
        if (createWiki.addDocumentToDataBase(wikiBean)) {
            System.out.println("success");
        }
        System.out.println("lal lalalla");
    }
}
