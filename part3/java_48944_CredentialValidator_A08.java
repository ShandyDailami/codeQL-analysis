import java.nio.charset.*;
import javax.crypto.*;
import org.apache.http.*;
import com.google.gson.*; // For GSON, a popular library for handling JSON data in Java programmatically  
    
public class java_48944_CredentialValidator_A08 { 
    private static final String SECRET_KEY = "your-secret-key";//replace this with your secret key you can generate it from anywhere (like password manager)
        
        public boolean validate(String username, String hashValue){         
            //Create a new Cipher object using the Secret Key for encrypting data.            
                try { 
                    Mac mac = Mac.getInstance("HmacSHA256");  
                        mac.init(new SecretKeySpec([SECRET_KEY], "HmacSHA256"));                     
                        
                            //Compute the HMAC-SHA256 hash of our data         
                                String hashedInput = MacUtils.hexEncode(mac.doFinal((username+secretkey).getBytes("UTF-8"))); 
                                                  
                                    if (hashedValue .equalsIgnoreCase (hash)) {   //compare stored and new computed values   
                                        return true;                          
                                      } else{    
                                          System.out.println ("IntegrityFailure");               
                                         };                 
                        });                     catch(InvalidKeyException | MacFailedException e1)  {}            
                    finally{}               })                   ;   try { throw new RuntimeException("RUNTIME EXCEPTION")      }catch (Throwable e){    System.out.println ("An unexpected error occurred: " +e);}        };     });                                                                              }}`;