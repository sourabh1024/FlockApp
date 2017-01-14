package services;

import co.flock.FlockApiClient;
import co.flock.model.User;

/**
 * Created by sourabh.su on 14/01/17.
 */
public class RegisterUser implements Runnable {
    private String userToken;

    public RegisterUser(String userToken){
        this.userToken = userToken;
    }

    public void run() {
        try {
            System.out.println("Request recieved for : " + this.userToken);
            Thread.sleep(200);
            FlockApiClient flockApiClient = new FlockApiClient(this.userToken);
            try {
                User user = flockApiClient.getUserInfo();
                System.out.println(user.getFirstName());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
