package services;

import co.flock.FlockApiClient;
import co.flock.model.User;
import databases.MySqlConnectionManager;

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
            FlockApiClient flockApiClient = new FlockApiClient(this.userToken);
            try {
               // User user = flockApiClient.getUserInfo();
              //  System.out.println("*****************" + user.getFirstName());

              //  Connection connection = mySqlConnectionManager.getSqlConnection();
             //   String query = "INSERT INTO user_info(userid,teamid,username,token) VALUES ('"+user.getId()+"', '"+user.getTeamId()+"', '"+ user.getFirstName()+" "+user.getLastName()+"', '"+this.userToken+"')";
             //   System.out.println(query);
             //   Statement statement = connection.createStatement();
             //   ResultSet resultSet = statement.executeQuery(query);
                //TODO: Check if the data is inserted or not

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
