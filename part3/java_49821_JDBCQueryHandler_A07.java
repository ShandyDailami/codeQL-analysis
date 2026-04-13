import java.security.*;
import javax.sql.*;

public class java_49821_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException{        
        String userPassword = "password"; // your password in plaintext for testing purposes only                
            
        MessageDigest md = MessageDigest.getInstance("MD5");      
                    
        byte [] hashBytes = md.digest(userPassword.getBytes());   
                            
        BigInteger  num  = new BigInteger(1,hashBytes);          
        
        String hashedPW =  num.toString(16);                     
            
        System.out.println("Hashed password: " +hashedPW );          // print the hash for verification only                 
    }    
}