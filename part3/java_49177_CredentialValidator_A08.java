import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
public class java_49177_CredentialValidator_A08 {    
    public boolean validateCredentials(String userInput, String secureStorage) throws Exception{        
        // Step 1: Decoding the inputted username and password from base-64 to plain text         
        byte[] decodedBytes = Base64.getDecoder().decode(userInput);            
        String providedCredentials = new String (decodedBytes, StandardCharsets.UTF_8);        
              
        // Step 2: Splitting the credentials into username and password          
        String splitArray[]=providedCredentials .split("\\s+");         
   			String userName  =  	     splitArray[0];     	 			                 									           						      									} " , {"secret"});            
        							  if (user == null) {                            throw new Exception ("Invalid username or password") ; }                          return true;                                   else                      // Step3: Using Blowfish encryption algorithm to check the entered credentials         	                    		                    Cipher cipher =Cipher.getInstance("Blowfish");cipher .init(Cipher.DECRYPT_MODE , secretKey);                  String decryptedPassword =  new String ( cipher   .doFinal  ((byte[]) password), "UTF-8") ;                   if (!decryptedPassword    .equalsIgnoreCase     ("secret")) { throw           new Exception("Invalid username or       pas‌​​sword"); } return true; }}