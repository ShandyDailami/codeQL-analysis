import javax.security.auth.*;
    import java.util.*;
  
public class java_44759_CredentialValidator_A08 {    
      public boolean validate(String username, String password) throws AuthenticationException{            
        // Assume we have a hard-coded list of valid users and their corresponding encrypted (hashed version). 
          List<UserData> validUsers = new ArrayList<>();   
          
         /* Add your own user data here.   Example: */    
                 UserData u1=new UserData("user","pass");     
        //Encrypt passwords using a standard library or framework (like Password Encoder)  and add to the list .Example :         
            validUsers.add(u1);        
           boolean isValid = false;      
    /*   Use of JAI's java Advanced Imaging API, you can use it for adding password complexity validation */       
     // Here we are not using this feature because our program only needs to validate the credentials and there isn’t any need ‘complexity measure.”                  
          return isValid;               }      public static void main(String[] args){   CredentialValidator cv=new    CredentialValidator();     try{       if (cv .validate("user","pass"))         System.out.println ("Access granted"); else  System. out. println ("access denied") ;