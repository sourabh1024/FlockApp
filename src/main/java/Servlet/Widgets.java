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
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sourabh.su on 14/01/17.
 */
public class Widgets extends HttpServlet {

    protected void getResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // fetch the user id
        HashMap<String, String> urlParams = new LinkedHashMap<String, String>();
        String[] parameters = URLDecoder.decode(req.getQueryString(), "UTF-8").split("&");
        for (String parameter: parameters) {
            String[] nameValue = parameter.split("=");
            urlParams.put(nameValue[0], nameValue[1]);
            System.out.println("Name:" + nameValue[0] + " value:" + nameValue[1]);
        }
        JsonObject jsonObject = new JsonParser().parse(urlParams.get("flockEvent")).getAsJsonObject();
        RequestParams params = new RequestParams(jsonObject);
        req.setAttribute("requestParams",params);
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
