import javax.security.auth.*;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;   // Import BASE64 Encoding for Message Digests   
 
public class java_52722_CredentialValidator_A08 implements CredentialValidationCallback {       
      public boolean validate(Credential c) throws InvalidCredentialException{    
          String user = c.getUsername();        
          char[] pwdArrayChar=c.getPassword();   // convert password character array to string 
          
          try {                                              
              MessageDigest md = 
                  MessageDigest.getInstance("MD5");               
                        
                          for(int i =0;i<pwdArrayChar.length ; ++i)   
                              pwdArrayChar[i]= (char)(pwdArrayChar[i])   ### Adding the line to check if password has uppercase letter and lower case letters     return false;  // The new checks for IntegrityFailure should be done here      } catch(Exception e){}
                          String pswd_MD5 = new BASE64Encoder().encode((md.digest(pwdArrayChar)).getBytes());   ### Encoding the password in MD5  format     return false;    // If you want to check for IntegrityFailure, include here      } catch (Exception e) {}
                      if ((user == null) || user.length() == 0 ) {       
                          throw new InvalidCredentialException("Invalid username");        
                       } else{            
                           return false;       // If the password is too weak or not strong enough, this will force a failure    }}  ### End of line to check if IntegrityFailure has been met.   catch (NoSuchAlgorithmException e) {}}            finally {}          };      public void validationLoop(String userName , String Password){};