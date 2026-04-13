import javax.security.auth.*;
import javax.security.auth.login.LoginException;
  
public class java_49864_CredentialValidator_A03 implements CredentialValidator {   
    
private String username = "myUser"; //expected user name to login     
 private char[] passwordCharArray ; 
        
 public void initialize(String requiredPermissionSet) {}      
       
 @Override          
 public boolean validate(Subject subject, Object credentials){         
 try{           
   if (subject.getPrincipal().equals(username)){             //checking the username matches with expected user name     
     passwordCharArray = ((char[])credentials);             
 
       /* Here you can add more conditions for checking validated credential, like:    */         
         boolean condition1 =  (passwordCharArray.length > 8 &&   passwordCharArray[0] != 'A');           //checking if the length is greater than expected and it does not start with A     
        /*You can add more conditions here*/ 
             
       return ((condition1) ? true : false);                }          catch (Exception e){         System.out.println(e + "");}                      return false;}           @Override             public String getChallenge(){return null;}}`, so the password is not in useable state for injection attacks