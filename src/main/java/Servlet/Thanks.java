package Servlet;

import beans.RequestParams;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by sourabh.su on 14/01/17.
 */
public class Thanks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setStatus(200);
        resp.setContentType("text/plain");
        out.write("Installed. Enjoy Flock Wiki");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setStatus(200);
        resp.setContentType("text/plain");
        out.write("hello");
        System.out.println("thanks "+ req);
        String test="";
        if ("POST".equalsIgnoreCase(req.getMethod())) {
            Scanner s = new Scanner(req.getInputStream(), "UTF-8").useDelimiter("\\A");
            test+=( s.hasNext() ? s.next() : "");
        }
        JsonObject jsonObject = new JsonParser().parse(test).getAsJsonObject();
        RequestParams params = new RequestParams(jsonObject);
        out.write(params.getUserId());
        out.flush();
        out.close();
    }
}
