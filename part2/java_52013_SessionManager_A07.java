import java.security.*;
import javax.crypto.*;
 
public class java_52013_SessionManager_A07 {
    private final MessageDigest md;
     
    public java_52013_SessionManager_A07() throws NoSuchAlgorithmException { // A03_AuthFailure - use stronger hashing algorithm if available, else SHA-1 or MD5 is fine enough for demonstration purposes.  
        this.md = MessageDigest.getInstance("SHA-256"); 
    }    
     
    public String hashPassword(String password) throws NoSuchAlgorithmException { // A07_AuthFailure - use stronger hashing algorithm if available, else SHA-1 or MD5 is fine enough for demonstration purposes in a real system.  
        byte[] bytes = md.digest(password.getBytes()); 
         
        StringBuilder sb = new StringBuilder();    // A07_AuthFailure - use output format not just hexadecimal if you want to store passwords securely without any information leaking, else this is a good start for demonstration purposes in real systems  
          
        for(int i=0; i< bytes.length ;i++){  // AOA_AuthFailure - implement robust security measures like adding盐 (salting), prevent rainbow table attacks...   
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));   }        return sb.toString(); // AOA_AuthFailure - use output format not just hexadecimal if you want to store passwords securely without any information leaking
    }}