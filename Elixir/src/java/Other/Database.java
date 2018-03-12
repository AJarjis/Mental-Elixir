package Other;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Database connection class
 * TODO: Add checking for connection & password security
 * @author Kieran Woodcock
 */
public class Database {
    private final String URL = "jdbc:postgresql://localhost:5432/HealthTracker";
    private final String USER = "postgres";
    private final String PASS = "password";
    private Connection conn = null;
    private Statement  stmt = null;
    
    public Database() throws SQLException
    {
        try{
            System.out.println("CONNECTING TO DATABASE..........");
            this.conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("CONNECTION ESTABLISHED!");
        }
        catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        
    }
    
    public void closeConn(){
        try{
            this.conn.close();
            System.out.println("CONNECTION CLOSED.");
        }
        catch(SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    
//    public void commit(){
//        try {
//            this.conn.commit();
//        } catch (SQLException e) {
//            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//            System.exit(0);
//        }
//    }
    
    public void insert(String command){
        try {
            this.stmt = this.conn.createStatement();
            this.stmt.executeUpdate(command);
            System.out.println("COMMAND HAS BEEN EXECUTED.");
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    
    public void selectUser(String username){
        try {
            this.stmt = this.conn.createStatement();
            String command = "SELECT * FROM account WHERE username = " 
                                + username;
            ResultSet rs = this.stmt.executeQuery(command);
            while (rs.next()) {
                String usrName = 
            }
            User user = new User();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    
    
}
