import java.security.*; // for MessageDigest & NoSuchAlgorithmException 
import javax.servlet.http.*; // only HttpServletRequest to get request parameters
  
public class java_52842_CredentialValidator_A01 {    
    public static boolean isValidPassword(HttpServletRequest req, String enteredPW) throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("SHA-256");  // use SHA for secure password hashing and salt generation with java's message digest         
            
        byte[] hashBytes = md.digest(req.getParameter("password").getBytes());        
        StringBuilder sb = new StringBuilder();  
          
        for (int i = 0; i < hashBytes.length; ++i) {           
              sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));            
         }  
          
        String savedPassword = sb.toString();          // stored password hashed with SHA-256 in DB     
                            
       return enteredPW.equals(savedPassword);     ## This line will break if the passed values do not match, this is for demonstration purposes only  
    }        
}