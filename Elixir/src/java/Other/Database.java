package Other;

import java.sql.*;
/**
 * Database connection class
 * TODO: Add checking for connection & password security
 * @author Kieran Woodcock
 */
public class Database {
    private final String URL = "jdbc:postgresql://localhost:5432/HealthTracker";
    private final String USER = "localhost";
    private final String PASS = "password";
    private  Connection CONN = null;
    
    public Database() throws SQLException
    {
        this.CONN = DriverManager.getConnection(URL, USER, PASS);
    }
}
