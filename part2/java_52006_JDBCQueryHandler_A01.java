import java.sql.*;   // Importing database connectivity and JDBC interfaces 
import javax.crypto.Cipher;    // Encrypt plaintext to secure passwords (This is not a part of security-sensitive operations)    
import javax.crypto.spec.SecretKeySpec;      // For encryption/decryption  

public class java_52006_JDBCQueryHandler_A01 {
  private static final String USER = "user";    // Database user name, change this to your database username accordingly        
  private static final String PASSWORD_KEY =  "passwordkey1234567890abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ";    // Encryption key, change this to your encryption password
  
  public static String encryptPassword(String passToEncrypt) {    
        try{        
            Cipher cipher = Cipher.getInstance("AES");         
            SecretKeySpec secretKey  = new SecretKeySpec(PASSWORD_KEY .getBytes(), "AES" );   // Create AES encryption instance and set key          
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);    // Initialize the encrypting Cipher object         
             String encryptedPassword = new String (cipher.doFinal(passToEncrypt .getBytes()));  // Encryption        
              return encryptedPassword;        }       catch(Exception e){e.printStackTrace();}     finally {      }}    static void main(String[] args) throws Exception{   try {                    PasswordHandler ph = new PasswordHandler ();                     String passwordToEncrypt=ph .encryptPassword("password12345");                   System.out.println ("The encrypted password is: " +passwordToEncrypt );       }}