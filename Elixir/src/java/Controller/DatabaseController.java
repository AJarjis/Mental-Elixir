/*****************************************************************************

File        : DatabaseController.java

Date        : 5-May-2018

Description : A class that connects the views to the database class

Author      : Daniel Carey

******************************************************************************/

package Controller;

import Model.User;
import Other.Database;


public class DatabaseController {
    
    //Stores the database inside of the controller
    private Database database;
    
    /**
     * Assigns a database to a database controller. Establishes connection 
     * on creation
     * @param database 
     */
    public DatabaseController(Database database){
        this.database = database;
    }
    
    /**
     * Method used to close the connection to the database and commit 
     * changes
     */
    public void closeConnection(){
        this.database.closeConn();
    }
    
    /**
     * Method to reconnect to the database
     */
    public void connectToDatabase(){
        this.database.connect();
    }
    
    /**
     * Method used to add User to the database
     * @param user object
     */
    public void AddUser(User user){
        this.database.addUserToDb(user);
    }
    
    /**
     * Method that returns a user object from the database based 
     * on the username that was inserted
     * NEEDS MORE WORK ON ERROR DETECTION
     * @param username 
     * @return  USER object
     */
    public User getUserByUsername(String username){
        return this.database.selectUser(username);
    }
    
    /**
     * Method used to update the username SHOULD NOT BE ACCESABLE TO USER!
     * @param username
     * @param newUsername 
     */
    public void updateUsername(String username, String newUsername){
        this.database.updateUser("username", newUsername, username);
    }
    
    /**
     * Method used to update the user's firstname on database
     * @param username
     * @param newFirstName 
     */
    public void updateFirstName(String username, String newFirstName){
        this.database.updateUser("firstname", newFirstName, username);
    }
    
    /**
     * Method to update the surname of a user on the database
     * @param username
     * @param newSurname 
     */
    public void updateSurname(String username, String newSurname){
        this.database.updateUser("surname", newSurname, username);
    }
    
    /**
     * Method to update the email of a user on the database
     * @param username
     * @param newEmail 
     */
    public void updateEmail(String username, String newEmail){
        this.database.updateUser("email", newEmail, username);
    }
    
    /**
     * Method used to update the password that belongs to the user
     * Use with caution MAYBE KEEP PASSWORD CHANGES TO ONE SPECIFIC CLASS
     * @param username
     * @param newPassword 
     */
    public void updatePassword(String username, String newPassword){
        this.database.updateUser("password", newPassword, username);
    }
    
}
