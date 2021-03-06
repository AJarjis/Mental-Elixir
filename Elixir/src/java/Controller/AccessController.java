/******************************************************************************
 *
 * File        : AccessController.java
 *
 * Date        : 11-Mar-2018
 *
 * Description : A class for dealing with accessing a user account, including
 *               logging in and registering.
 *
 * Author      : Ali Jarjis and Daniel Carey
 *
 ******************************************************************************/
package Controller;


import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;


public class AccessController {
    /**
     * Attempts to log a user into their account.
     * 
     * @param username      account's username
     * @param password      account's password (hashed)
     * @param hashedPass    hashed password
     * @return              an instance of the userController with the currently
     *                      logged in user
     */
    public static boolean login(String username, String password, 
            String hashedPass) {
        // Check for correct password
        if (checkPassword(password, hashedPass)) {
            return true;
        } else {
            System.err.println("Invalid Username or password!");
            return false;
        }
        
    }

    /**
     * Registers a user, creating them a new account and profile
     * 
     * @param username      unique username to identify user
     * @param firstName     user's first name
     * @param surname       user's second name
     * @param email         user's valid email
     * @param password      user's password (hashed)
     * @return              an instance of the userController with the currently
     *                      logged in user
     * @throws java.sql.SQLException
     */
    public static UserController registerUser(String username, String firstName,
            String surname, String email, String password) throws SQLException {
        // TODO: validate user details
        UserController userController = new UserController(username, firstName, 
                surname, email, genHashed(password));
        return userController;
    }
    
    /**
     * Method to encrypt a string to be used for storage in SQL database
     * @param password plaintext to be encrypted
     * @return hashed version of the plain text
     */
    public static String genHashed(String password){
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashed;
    }
    
    /**
     * Method will allow the system to check if the plaintext given matches
     * the hashed version stored on the SQL database
     * @param password string containing plaintext 
     * @param hashed string that contains hashed version of the plaintext
     * @return true if the plaintext given matches the encrypted version
     * stored on the SQL database
     */
    public static boolean checkPassword(String password, String hashed){
        return BCrypt.checkpw(password, hashed);
    }
    
    
    // Main for testing class, TODO: Delete at some point
    public static void main(String[] args) {
//        String plain = "cool";
//        String hashed = genHashed(plain);
//        System.out.println("plain: " + plain);
//        System.out.println("hashed plain: " + hashed);
//        System.out.println("check Password of " + plain + ": " + checkPassword(plain, hashed));
        
//          UserController newUser = login("SecondTest", "qweewq");
//        System.out.println("User deet: " + newUser.getFullName());
//        testMood.setNotes("Hello, from Ali");
//        DatabaseController.connectToDatabase();
//        DatabaseController.addMoodEntry(newUser.getUserName(), testMood.getMood());
//        DatabaseController.closeConnection();
    }
}
