package Other;

import Model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Database connection class
 * TODO: Add checking for connection & password security
 * @author Daniel Carey
 */
public class Database {
    private final String URL = "jdbc:postgresql://elixir.postgres.database.azure.com:5432/postgres";
    private final String USER = "elixirAdmin@elixir";
    private final String PASS = "Elixir1221";
    private Connection conn = null;
    private Statement  stmt = null;
    
    /**
     * BASED ON https://www.tutorialspoint.com/postgresql/postgresql_java.htm
     * Establishes the connection with the SQL server as well as loading the 
     * required postgreSQL drivers
     * 
     */
    public Database()
    {
    
    }
    
    /**
     * Method the database object to close connection.
     */
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
    
    /**
     * Method used to create a connection to the database
     */
    public void connect(){
        try {
            System.out.println("CONNECTING TO DATABASE..........");
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            System.out.println("CONNECTION REOPENED");
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    
    //MAYBE NEEDED
//    public void commit(){
//        try {
//            this.conn.commit();
//        } catch (SQLException e) {
//            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//            System.exit(0);
//        }
//    }
    
    /**
     * Method that allows sending of the SQL statement to the server
     * @param command 
     */
    public void execute(String command){
        try {
            this.stmt = this.conn.createStatement();
            this.stmt.executeUpdate(command);
            System.out.println("COMMAND HAS BEEN EXECUTED.");
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    
   
    /**
     * Method used to add a user to the SQL server
     * @param user object
     */
    public void addUserToDb(User user){
        String command = String.format("INSERT INTO account VALUES('%s','%s','%s','%s','%s');"
                , user.getUserName(), user.getFirstName(), user.getSurname(), 
                user.getEmail(), user.getPassword());
        this.execute(command);
    }
   
    /**
     * 
     * Method that will allow retrieval of the user information. This will then 
     * go into a user object which will be returned for further processing
     * @param username unique string that allows to you to find the user details
     * on the SQL server
     * @return user object that is filled in
     */
    public User selectUser(String username){
        User user = null;
        try {
            this.stmt = this.conn.createStatement();
            String command = String.format
        ("SELECT * FROM account WHERE username ='%s'", username);
            ResultSet rs = this.stmt.executeQuery(command);
            while (rs.next()) {
                String usrName = rs.getString("Username");
                String firstName = rs.getString("FirstName");
                String surname = rs.getString("Surname");
                String email = rs.getString("email");
                String password = rs.getString("password");
            user = new User(usrName, firstName, surname, email, password);
            } 
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return user;
    }
    
    /**
     * Method used to update records concerning the account table in 
     * SQL. Will be used as utility method
     * @param fieldName SQL field name for the table account
     * @param dataToUpdate new data to be used in SQL
     * @param username
     */
    public void updateUser(String fieldName, String dataToUpdate, String username){
        String command = String.format("UPDATE account SET %s = '%s' WHERE %s = '%s'"
        , fieldName, dataToUpdate, fieldName, username);
        this.execute(command);
    }
    
    /**
     * Get any of the user details that are present in the account table 
     * of SQL
     * @param field
     * @param username
     * @return 
     */
    public String getUserDetails(String field ,String username){
        String userDetails = null;
        try {
            this.stmt = this.conn.createStatement();
            String command = String.format
                ("SELECT %s FROM account WHERE username ='%s'",field,username);
            ResultSet rs = this.stmt.executeQuery(command);
            while (rs.next()) {
                userDetails = rs.getString(field);
            }
        } catch (SQLException e) {
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
           System.exit(0);
        }
        return userDetails;
    }
    
    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        User test = new User();
        System.out.println("This is a test.");
        test = db.selectUser("test");
        System.out.println(db.getUserDetails("firstname", "GoMan"));
        db.closeConn();
    }
    
    
}
