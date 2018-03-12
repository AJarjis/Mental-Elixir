/*****************************************************************************

File        : AccessController.java

Date        : 12-Mar-2018

Description : A class 

Author      : Ali Jarjis and Daniel Carey

******************************************************************************/

package Controller;

    import org.mindrot.jbcrypt.BCrypt;

public class AccessController {
    
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
    
    
    public static void main(String[] args) {
        String plain = "cool";
        String hashed = genHashed(plain);
        System.out.println("plain: " + plain);
        System.out.println("hashed plain: " + hashed);
        System.out.println("check Password of " + plain + ": " + checkPassword(plain, hashed));
    }
}
