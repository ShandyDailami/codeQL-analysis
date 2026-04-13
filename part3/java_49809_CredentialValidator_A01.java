import javax.security.auth.Subject;   // Import Subject class java_49809_CredentialValidator_A01 java security package   
import org.apache.commons.lang3.*;      //Import StringUtils for string manipulations, like capitalize first letter of strings and etc...    
public final class CredentialValidator {  // Define your custom exception here so you can catch it anywhere in the code using a try-catch block  
    public boolean validate(final Subject subject) throws Exception{          // Declare method signature             
        if (subject == null || StringUtils.isEmpty(subject.getPrincipal()))     {      // Check conditions for username and password              
            throw new RuntimeException("Invalid or missing credentials");           // Throw exception when either is invalid                 
         }  else{                                                                   // If valid, return true                  
             System.out.println ("Credentials are Valid!");                          
        }                                                            
          String userName = subject.getPrincipal();                              // Extract username from principal field of Subject              
           if(userName == null){                                                // Check conditions for expired date and time               
              throw new RuntimeException("Invalid or missing credentials");            
             } else {                                                                // If valid, return true                  
                 System.out.println ("User Name is Valid!");                           
               }                                                                   // After all checks if everything passed then print success message         
         try{                                         
              String password = (String) subject.getPrivateCredentials().iterator().next();      // Get private credential from principal field of Subject                   
             System.out.println("Password is :" +password);                            // Print the extracted Password                 
            } catch(Exception e){                                                      // Catch any exception if it occurs                  
                throw new RuntimeException ("Invalid or missing credentials");              
               }                                                                   // If all checks passed then print success message         
         return true;                                             // Return True indicating that credential is valid, no further operation required                
       } catch (NoSuchAlgorithmException e) {                             // Catch if No such algorithm exception occurs                  
           throw new RuntimeException ("Invalid or missing credentials");              // Throw custom message for invalid/missing tokens                     
          }                                                                    // If all checks passed then print success message                 
}   else{                                                                // Else return false indicating token is expired                
         System.out.println("Token has been Expire!");                       
        try { Thread.sleep(500L) ;      // Simulate some delay if the access_token was issued recently                    } catch (InterruptedException e1){e1.printStackTrace();}  */ End of Code **** Please remove comment and add your code inside it for complete implementation!