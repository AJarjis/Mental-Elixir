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
     * @throws SQLException 
     */
    public Database() throws SQLException
    {
        try{
            System.out.println("CONNECTING TO DATABASE..........");
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.URL, this.USER, 
                                                    this.PASS);
            System.out.println("CONNECTION ESTABLISHED!");
        }
        catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("OPENED CONNECTION SUCCESSFULY.");
        
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
    
   
    /**
     * Method used to add a user to the SQL server
     * @param user object
     */
    public void addUserToDb(User user){
        String command = String.format("INSERT INTO account VALUES('%s','%s','%s','%s','%s');"
                , user.getUserName(), user.getFirstName(), user.getSurname(), 
                user.getEmail(), user.getPassword());
        this.insert(command);
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
    
    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        User test = new User();
        System.out.println("This is a test.");
        test = db.selectUser("test");
        System.out.println(test.getFirstName() + " " + test.getPassword());
        db.closeConn();
    }
    
    
}
