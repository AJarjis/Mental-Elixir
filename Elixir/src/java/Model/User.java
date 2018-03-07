package Model;

/*****************************************************************************

File        : Account.java

Date        : 06-Mar-2018

Description : User class will be in charge of managing the user fields.

Author      : Daniel Carey

******************************************************************************/


public class User {
    
    private String userName;
    private String firstName;
    private String surname;
    private String email;
    private String password;

    /**
     * Creates a new new user object in the system
     * @param userName
     * @param firstName
     * @param surname
     * @param email
     * @param password 
     */
    public User(String userName, String firstName, String surname, String email, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    
    

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    

}
