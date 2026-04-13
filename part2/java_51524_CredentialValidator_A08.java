import java.security.*;
import javax.security.auth.*;
  
public class java_51524_CredentialValidator_A08 implements Authenticator {
    MessageDigest md; // SHA256 for hashing passwords and checking against stored hash values in a secure manner    
        
    public boolean authenticate(String userName, String passWord) throws BadPrivilegeException{  
        try {            
            byte[] salt = getSalt();       // generate unique per-user random value for each password (salt). 
                                          
            md.update(passWord.getBytes());    // add the input into SHA256 hash calculation         
                                                                                      
                                   passWord  = new String(md.digest());      # convert to hexadecimal format        
            
                                  if (userName==null || userName.length() == 0) {               throw new BadPrivilegeException("Invalid Credentials");}            // check the username is not null and has a length    
                                                                                      else  System.out.println(passWord);    return passWord .equalsIgnoreCase (userHash );                } catch (NoSuchAlgorithmException e) { throw new BadPrivilegeException("IntegrityFailure - No Such Algorithm",e);}           case "SHA-256": 
                    // if user wants to use SHA1 or any other algorithm, then replace the above line with below and also in getSalt method.          } catch (NoSuchAlgorithmException e) { throw new BadPrivilegeException("IntegrityFailure - No Such Algorithm",e);}  
              return false;  // if passwords not match otherwise returns true, we're checking against the hashed version stored in a secure manner. This example uses SHA256 which is considered an integral failure attack resistant method and should be avoided for new methods of storing credentials due to security concerns like brute-force attacks etc
        } catch (Exception e) {  // Catch any exception here that may arise while accessing resources or performing operations on userName, passWord.    throw;     return false;}   }}`});