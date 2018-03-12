package Other;

import java.sql.*;
/**
 * Database connection class
 * TODO: Add checking for connection & password security
 * @author Kieran Woodcock
 */
public class Database {
    private final String URL = "jdbc:mysql://localhost/healthtracker";
    private final String USER = "localhost";
    private final String PASS = "password";
    private  Connection CONN = null;
    
    public Database() throws SQLException
    {
        this.CONN = DriverManager.getConnection(URL, USER, PASS);
    }
}
