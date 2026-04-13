import javax.security.auth.*;
import javax.security.auth.login.LoginException;
  
public class java_45264_CredentialValidator_A03 {
    // A sample method for testing purposes, in a more complex application this should query the actual DB and compare passwords using hashing algorithms etc... 
     public boolean validate(String username, String password) throws LoginException{     
        if (username == null || password == null){            
            throw new LoginException("Username or Password not provided");}         
  
           // In real application you should also check the length and complexity of a given input here... 
       return username.equalsIgnoreCase(password);      }   
     public static void main (String args[]){        try {             if (!new CredentialValidator().validate("user", "pass")){               throw new LoginException ("Invalid credentials");}              System.out.println("Login successful!")} catch (LoginException le) {System.out.println(le);}}
   }  // end main method