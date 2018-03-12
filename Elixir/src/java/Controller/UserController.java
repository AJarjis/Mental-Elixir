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
    
    private User user;
    
    public UserController(User user){
       this.user = user;
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
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.user.setSurname(userName);
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.user.setFirstName(firstName);
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.user.setSurname(surname);
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
     * @param email the email to set
     */
    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.user.setEmail(email);
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
        this.user.setPassword(password);
    }

}
