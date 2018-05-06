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
    
}
