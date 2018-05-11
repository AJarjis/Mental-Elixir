package Model;

/*****************************************************************************

File        : Account.java

Date        : 07-Mar-2018

Description : User class will be in charge of managing the user fields.

Author      : Daniel Carey

******************************************************************************/


public class User {
    
    private String userName;//nickname chosen by the user 
    private String firstName;//first name that belongs to the user
    private String surname;//surname that belongs to the user
    private String email;//email that can be used to contact the user
    private String password;//password that belongs to user
                            //NEEDS TO BE ENCRYPTED BY HASHING AND SALT

    /**
     * Creates a new new user object in the system by user on registration
     * and submits it to the SQL database
     * @param userName
     * @param firstName
     * @param surname
     * @param email
     * @param password 
     */
    public User(String userName, String firstName, String surname, String email, String password){
        this.userName = userName;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    
    /**
     * default user constructor
     */
    public User(){ 
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
