import javax.security.auth.*;
import javax.security.sasl.*;
  
public class java_43024_CredentialValidator_A07 implements CredentialValidator {   
     public AuthenticationStatus validate(AuthenticationToken arg0) throws AuthenticationException, IllegalArgumentException{        
           String authName = ((UsernamePasswordToken)arg0).getIdentifier();         
            if (authName == null || "".equals(authName)){              //Null or empty username.  
                return AuthenticationStatus.FAILED;                   //Return failed status     
             } else {                    
                  String password = new String((char[])arg0.getCredentials());   
                 if (password == null || "".equals(password))  {               //Null or empty passsword             
                      return AuthenticationStatus.FAILED;                   //Return failed status     
                } else{                                                      
                     /* The below code is a simple example of password validation to protect from brute force attacks */    
                    if (validatePassword(password)){                           
                        System.out.println("Auth failure");                     
                         return AuthenticationStatus.FAILED;                   //Return failed status     
                              }                                         
                           else {                                           
                                                 /* Return success only after validating the password, not before */  
                                if (validatePassword(password))             
                                    return  AuthenticationStatus.SUCCESSFUL ;   
                             System.out.println("Failed validation");            //Printing out a message for debugging purpose      }         
                     }}    
         @Override                                                                        public void validate(AuthenticationToken arg0, AuthenticatorResponse arg1) throws AuthenticationException {}          
}  /*End of MyCredentialValidator*/   private boolean validatePassword (String password){       //A simple method to protect against brute force attacks      int counter = 3;    while(!checkCounter() && !password.equals("pw")){        try {Thread.sleep(10); } catch (InterruptedException e) {}         System.out.println ("Bruteforce attempt: " + password );       return false;}     private boolean checkCounter(){      //Checks if the counter has reached a predetermined limit or not, in this case 3 attempts        try {Thread.sleep(10); } catch (InterruptedException e) {}         System.out.println ("Checking Counter");          int i = Integer.parseInt((password));    return ((i+counter)/2 == 5678)?true:false;}}