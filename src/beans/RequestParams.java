package beans;

import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vishal.p on 14/01/17.
 */
public class RequestParams {
    private String userId;

    public RequestParams(JsonObject request) {
        this.userId = getString(request, "userId");
    }

    public String getUserId() {
        return userId;
    }

    private int getInt(JsonObject request, String pid) {
        String string = request.getAsJsonPrimitive(pid).getAsString();
        int value = -1;
        if (string != null) {
            value = Integer.parseInt(string);
        }
        return value;
    }

    private String getString(JsonObject request, String pid) {
        return request.getAsJsonPrimitive(pid).getAsString();
    }
}
