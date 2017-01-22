package beans;

import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vishal.p on 14/01/17.
 */
public class RequestParams {
    private String userId;
    private String userName;
    private String group;
    private String eventName;
    private String token;
    private String userToken;

    public RequestParams(JsonObject request) {
        this.userId = getString(request, "userId");
        this.eventName = getString(request, "name");
        this.token = getString(request, "token");
        this.userToken = getString(request, "userToken");
        this.userName = getString(request, "userName");
        this.group = getString(request, "chat");
    }

    public String getToken() {
        return token;
    }

    public String getUserToken() {
        return userToken;
    }

    public String getUserId() {
        return userId;
    }

    private int getInt(JsonObject request, String pid) {
        String string = null;
        if(request.getAsJsonPrimitive(pid) != null) {
            string = request.getAsJsonPrimitive(pid).getAsString();
        }
        int value = -1;
        if (string != null) {
            value = Integer.parseInt(string);
        }
        return value;
    }

    public String getEventName() {
        return eventName;
    }

    private String getString(JsonObject request, String pid) {
        if(request.getAsJsonPrimitive(pid) != null) {
            return request.getAsJsonPrimitive(pid).getAsString();
        }
        return "";
    }

    public String getUserName() {
        return userName;
    }

    public String getGroup() {
        return group;
    }
}
