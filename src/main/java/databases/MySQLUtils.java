package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sourabh.su on 23/01/17.
 */
public class MySQLUtils {

//    public static String getUserInfo(String userId) throws Exception {
//        MySqlConnectionManager mySqlConnectionManager = null;
//        ResultSet resultSet = null;
//        List<Map<String,String>> userRoles = new ArrayList<Map<String,String>>();
//        try {
//            mySqlConnectionManager = new MySqlConnectionManager();
//            Connection connection = mySqlConnectionManager.getSqlConnection();
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement();
//            preparedStatement.setInt(1, params.getAdminId());
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                HashMap<String, String> map = new LinkedHashMap<>();
//                map.put("roleName", resultSet.getString("role_name"));
//                map.put("businessOrTeam", resultSet.getString("business_or_team"));
//                userRoles.add(map);
//            }
//        } catch (SQLException e) {
//            log.error("error while executing FETCH_USER_DETAILS", e);
//        } finally {
//            if(resultSet != null) {
//                resultSet.close();
//            }
//            if(database != null) {
//                database.close();
//            }
//        }
//        return new Gson().toJson(userRoles);
//    }
}
