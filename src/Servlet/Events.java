package Servlet;

import beans.RequestParams;
import co.flock.FlockApiClient;
import co.flock.model.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import services.RegisterUser;

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

        System.out.println(params.getToken());
        System.out.println(params.getUserToken());

        if (params.getEventName().equals("app.install")) {
            Thread registerUser = new Thread(new RegisterUser(params.getUserToken()));
            registerUser.start();
        }

        out.flush();
        out.close();
    }
}
