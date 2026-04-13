import java.security.*;
import javax.servlet.http.*;
 
public class java_52103_CredentialValidator_A07 implements CredentialValidator {   
   private MessageDigest md;        //Message Digest to generate salt    
      public HttpServletRequest request ;//Http Request object for cookies and other details      
          UserDAO userDao = new UserDAOImpl();             
 
 @Override        
public boolean validate(Credential c) throws Exception {  
    if (c == null || !(c instanceof UsernamePasswordCredential))           return false;     //Null or not a credentials object     
       String salt= userDao.getUserSaltByUsername((String)(c).getIdentifier());  //Getting the stored password hash value from DB   
        if (salt==null) {  
            System.out.println("No Salt Found for this User");     return false; }     
       try{          
         MessageDigest md = MessageDigest.getInstance ("SHA-256");          //Creating a new SHA  instance            
                 byte[] hashPassword  =md . digest((c).getSecret ()) ;   //Hashed password     using Bcrypt                , then storing in DB              userDao..updateUserSalt(hashedpassword,username);    } catch Exception e {e.printStackTrace();}  return false;}}