/*****************************************************************************

File        : UserController.java

Date        : 12-Mar-2018

Description : A class that will connect the views and the User model class 
              together

Author      : Daniel Carey

******************************************************************************/

package Controller;

import Model.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class UserController {
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    //Minimum eight characters, at least one letter and one number.
    public static final Pattern VALID_PASSWORD_REGEX = 
    Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    
    //Minimum three characters, simple profanity filter in place.
    public static final Pattern VALID_USERNAME_REGEX = 
    Pattern.compile("^[a-zA-Z0-9._-]*(fuck|shit|wank|cunt|nigger|twat|fag)"
            + "{3,}$");
    
    private User user;
    
    /**
     * UserController constructor using a user object
     * @param user 
     */
    public UserController(User user){
        this.user = user;
    }
    
    /**
     * Creates a user controller based on 
     * @param userName
     * @param firstName
     * @param surname
     * @param email
     * @param password 
     */
    public UserController(String userName, String firstName, String surname, 
            String email, String password){
        this.user = new User(userName,firstName,surname,email,password);
    }
    
    /**
     * Method used to create a user object on the database
     */
    public void sendUserToDb(){
        DatabaseController.connectToDatabase();
        DatabaseController.AddUser(this.user);
        DatabaseController.closeConnection();
    }
    
    /**
     * Method to get the user object that is currently being stored
     * @return 
     */
    public User getUser(){
        return this.user;
    }
    
     /**
     * @return the userName
     */
    public String getUserName() {
        return this.user.getUserName();
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return this.user.getFirstName();
    }
    
    /**
     * @return the surname
     */
    public String getSurname() {
        return this.user.getSurname();
    }
    
    public String getFullName() {
        String fullName = this.user.getFirstName() + " " + this.getSurname();
        return fullName;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return this.user.getEmail();
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return this.user.getPassword();
    }
    
    /**
     * Set the user of the controller
     * @param user 
     */
    public void setUser(User user){
        this.user = user;
    }

    /**
     * @param userName the userName to set SHOULD NOT BE USED BY USER!
     */
    public void setUserName(String userName) {
        this.user.setUserName(userName);
        DatabaseController.updateUsername(this.user.getUserName(), userName);
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.user.setFirstName(firstName);
        DatabaseController.updateFirstName(this.user.getUserName(), firstName);
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.user.setSurname(surname);
        DatabaseController.updateSurname(this.user.getUserName(), surname);
    }
    
        /**
     * Method to check if the email to set is matching the regex rules
     * @param emailStr string representing email address
     * @return true if matches the rules false otherwise
     */
    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    /**
     * Method to check that the username is valid and not been used before.
     * @param userName: The username
     * @return true if valid, else false
     */
    public static boolean validateUserName(String userName) {
        //Search through database for match with given username
        //if found return false
        //if else, return true
        return false;
    }
    
    /**
     *
     * @param password: The password
     * @return true if password is valid, else false.
     */
    public static boolean validatePassword(String password) {
        Matcher matcher = VALID_PASSWORD_REGEX .matcher(password);
        return matcher.find();
    }
    
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.user.setEmail(email);
            DatabaseController.updateEmail(this.user.getUserName(), email);
        }
        else{
            System.out.println("ERROR: email has not been set, " + email 
                    + " is INVALID.");
        }
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
         if (validatePassword(password)) {
            this.user.setPassword(password);
            DatabaseController.updatePassword(this.user.getUserName(), password);
        }
        else{
            System.out.println("ERROR: password has not been set, " + password 
                    + " is INVALID.");
        }
    }

}
