import javax.security.auth.*;
        import java.lang.Exception;
        
public class java_48481_CredentialValidator_A07 {    
    public boolean validate(String userNameInput , String passwordHash) throws ExceptionAuthFailed{   // assuming use JWT for authentication if required 
      try {            
          MessageDigest md = MessageDigest.getInstance("MD5");          
                  byte[] hashPasswordBytes =  md.digest((userName + ":"  +password).getBytes());        
                 StringBuilder sbPasswd=  new StringBuilder();   // you can use this if required  for hashing passwords    
                    for (int i=0;i<hashPasswordBytes.length;i++) {   
                        sbPasswd.append(Integer.toString((hashPasswordBytes[i] & 0xff) + 0x100, 16).substring(1));  
                   }               
                 String password =sbPasswd .toString();             // hashed Password             
                  if (passwordHash.equals(password)) {               return true;                                   else                             throw new ExceptionAuthFailed("Incorrect Username or PW");  }} catch (Exception e) {{e.printStackTrace()}}          finally{println ("The method validate is closing..")}}}     }    // end of class CredentialValidator