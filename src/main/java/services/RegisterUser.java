package services;



import beans.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import databases.MySqlConnectionManager;
import utils.HttpConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by sourabh.su on 14/01/17.
 */
public class RegisterUser implements Runnable {
    private String userToken;
    private MySqlConnectionManager mySqlConnectionManager;


    public RegisterUser(String userToken){
        this.userToken = userToken;
    }

    public void run() {
        try {
            mySqlConnectionManager = new MySqlConnectionManager();
            System.out.println("Request recieved for : " + this.userToken);
            Thread.sleep(200);
//            FlockApiClient flockApiClient = new FlockApiClient(this.userToken);
            try {
                HttpConnection httpConnection = new HttpConnection();
                String response = httpConnection.jsonGet("http://api.flock.co/v1/users.getInfo?token="+this.userToken);
                System.out.println(response);

                JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
                User user = new User(jsonObject);


                System.out.println("*****************" + user.getFirstName());

                Connection connection = mySqlConnectionManager.getSqlConnection();
                String query = "INSERT INTO user_info(userid,teamid,username,token) VALUES ('"+user.getId()+"', '"+user.getTeamId()+"', '"+ user.getFirstName()+" "+user.getLastName()+"', '"+this.userToken+"')";
                System.out.println(query);
                Statement statement = connection.createStatement();
                int result = statement.executeUpdate(query);
                //TODO: Check if the data is inserted or not
                if (result == 0) {
                    System.out.println("unsuccesful registration");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
