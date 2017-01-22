package beans;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class WikiDocument {

    private String title;
    private String content;
    private String userId;
    private String teamName;
    private String visibleTo;

    public WikiDocument(HttpServletRequest request) {
        this.title = getString(request, "title");
        this.content = getString(request, "content");
        this.visibleTo = getString(request, "visibleTo");
        String requestBody = "";
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            Scanner s = null;
            try {
                s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert s != null;
            requestBody += (s.hasNext() ? s.next() : "");
        }
        JsonObject jsonObject = new JsonParser().parse(requestBody).getAsJsonObject();
        RequestParams params = new RequestParams(jsonObject);
        this.userId = params.getUserId();
    }

    private String getString(HttpServletRequest request, String pid) {
        return request.getParameter(pid);
    }

    private int getInt(HttpServletRequest request, String pid) {
        String string = request.getParameter(pid);
        int value = -1;
        if (string != null) {
            value = Integer.parseInt(string);
        }
        return value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getVisibleTo() {
        return visibleTo;
    }
}
