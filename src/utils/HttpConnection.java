package utils;

import com.google.gson.JsonObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by saksham on 11/2/16.
 */
public class HttpConnection {
    private final static String USER_AGENT = "Mozilla/5.0";

    public static String sendGet(String url, JsonObject jsonParam) throws Exception {
        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to" + url);
        System.out.println("Response Code : " + responseCode);
        //TODO:: logger thingy
        //TODO:: exceptions and shiz..
        BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while(( inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
        return response.toString();
    }

    public static String jsonPost(String url, String message) throws Exception {
        URL urlObj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();

        //add request header
        //make some HTTP header nicety
        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        //open
        conn.connect();
//        //output stream
//        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
//        os.write(message.getBytes());
//        //cleanup
//        os.flush();
        // input stream
        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to" + url);
        System.out.println("Response Code : " + responseCode);
        //TODO:: logger thingy
        //TODO:: exceptions and shiz..
        BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while(( inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
        return response.toString();
    }

    public static String jsonGet(String url) throws Exception {
        URL urlObj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();

        //add request header
        //make some HTTP header nicety
        conn.setRequestMethod("GET");
//        conn.setRequestProperty("User-Agent", USER_AGENT);
//        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//        conn.setDoInput(true);
//        conn.setDoOutput(true);

        //open
        conn.connect();
        // input stream
        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to" + url);
        System.out.println("Response Code : " + responseCode);
        //TODO:: logger thingy
        //TODO:: exceptions and shiz..
        BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while(( inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
        return response.toString();
    }
}

