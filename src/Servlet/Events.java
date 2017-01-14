package Servlet;

import beans.RequestParams;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import utils.HttpConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by sourabh.su on 14/01/17.
 */
public class Events extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setStatus(200);
        resp.setContentType("text/plain");
        out.write("hello");
        System.out.println(req.getParameterValues("userId"));
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setStatus(200);
        resp.setContentType("text/plain");
        String requestBody="";
        if ("POST".equalsIgnoreCase(req.getMethod())) {
            Scanner s = new Scanner(req.getInputStream(), "UTF-8").useDelimiter("\\A");
            requestBody+=( s.hasNext() ? s.next() : "");
        }
        JsonObject jsonObject = new JsonParser().parse(requestBody).getAsJsonObject();
        RequestParams params = new RequestParams(jsonObject);

        if (params.getEventName().equals("app.install")) {
            System.out.println("Installing app for userId :" + params.getUserId());
            System.out.println("User Token :" + params.getToken());
            String url  = "https://api.flock.co/v1/users.getInfo?token="+params.getToken();
            String response = "";
            try {
                response = HttpConnection.jsonGet(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(response);
        }

        out.flush();
        out.close();
    }
}
