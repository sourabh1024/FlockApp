package beans;

import com.google.gson.JsonObject;

/**
 * Created by sourabh.su on 24/01/17.
 */
public class User {

    private String id;
    private int teamId;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    private String timezone;
    private String profileImage;

    public User (JsonObject jsonObject) {
        this.id = getString(jsonObject, "id");
        this.teamId = getInt(jsonObject, "teamId");
        this.email = getString(jsonObject,"email");
        this.firstName = getString(jsonObject,"firstName");
        this.lastName = getString(jsonObject, "lastName");
        this.role = getString(jsonObject,"role");
        this.timezone = getString(jsonObject,"timezone");
        this.profileImage = getString(jsonObject,"profileImage");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    private String getString(JsonObject request, String pid) {
        if(request.getAsJsonPrimitive(pid) != null) {
            return request.getAsJsonPrimitive(pid).getAsString();
        }
        return "";
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

}
