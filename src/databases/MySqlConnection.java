package databases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class MySqlConnection {
    private static final String mySqlDriver = "net.sourceforge.jtds.jdbc.Driver";

    public static Connection getSQLConnection(String sqlIP, String dbName, String sqlUserName, String sqlPassword) throws Exception {
        Connection connection = null;
        try {
            Class.forName(mySqlDriver);
            connection = DriverManager.getConnection(sqlIP+dbName, sqlUserName, sqlPassword);
        } catch (Exception ex) {
            throw ex;
        }
        return connection;
    }
}
