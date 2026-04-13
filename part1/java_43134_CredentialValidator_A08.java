import javax.security.auth.*;
import javax.security.auth.login.CredentialException;
    
public class java_43134_CredentialValidator_A08 implements javax.security.auth.credential.CredentialValidator {  
       public boolean validate(Subject subject, Object credentials) throws CredentialException{ 
           String userName = (String)(new java.sql.Timestamp((java.util.Date)subject.getAccount().getCreationTime()));    // assuming the username is creation time of account which was stored in sql server database table    
         final char[] passwordArray;  
        try { 
            if(credentials != null){      
                String inputPassword = credentials.toString();          
             /* Compare Passwords Here, you can write your own logic for comparing the user's entered    and stored one */     
              return false;}          // Return False to show that credential is invalid  else true   } catch (Exception e) { throw new CredentialException(e.getMessage()); }}catch (ClassCastException ce){throw new ClassCaseCredentialExpection("Cannot convert "+credentials +" into a string");}}}