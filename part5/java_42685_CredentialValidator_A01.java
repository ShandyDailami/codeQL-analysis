import java.security.*; // Importing Standard Java Security Classes for hashing, encryption and key management operations... etc  
    
public class java_42685_CredentialValidator_A01 {   
       public static boolean isValid(String username , String plainTextPassword) throws NoSuchAlgorithmException{       
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Using SHA 256 for hashing the password...  
             byte[] hashPassword =  md.digest(plainTextPassword);    
              StringBuffer sb = new StringBuffer();   
               for (int i=0; i<hashPassword.length ;i++){     
                   sb.append(Integer.toString((hashPassword[i] & 0xff) + 0x100, 16).substring(1));  
             }     // Converting bytes to Hexadecimal...   
              StringBuffer hexString = new StringBuffer();     
               for (int i = 0; i< sb.length();i++){       
                   hexString.append((sb.charAt(i)));      
                System.out.println("Password: " + username +  ", Hashed Password :"+hexString);     // Printing the hashed password...   }      return true;    case where there are no errors in user credentials (username,password). Return false if not valid..  }; public class Main {       
public static void main(String[] args) throws NoSuchAlgorithmException{          CredentialValidator obj = new            // Creating an object of the `Credentials` Validator...   }