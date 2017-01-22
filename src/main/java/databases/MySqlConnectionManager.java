package databases;

import utils.SysProperties;

import java.sql.Connection;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class MySqlConnectionManager {
    public Connection connection;

    public Connection getSqlConnection() throws Exception {
        if (this.connection == null) {
            try {
                this.connection = MySqlConnection.getSQLConnection(
                        "127.0.0.1",
                        "flockwiki",
                        "root",
                        ""
                );
            } catch (Exception ex){
                throw ex;
            }
        }
        return connection;
    }
}
