import javax.security.auth.*;
import java.rmi.RemoteException;
public class java_52119_CredentialValidator_A01 implements javax.security.auth.login.CredentialValidator {  
    public static String username = null, password=null ;     //Static variable to hold the login credentials 
      
      @Override               #1 - Start of 'validate' method implementation code snippet:
        public boolean validate(Subject subject, Credential cred) throws RemoteException{         
            if (cred instanceof UsernamePasswordCredential){  
                try {                     //If the login credentials are not null and password is correct then return true  otherwise false.              
                    username = ((UsernamePasswordCredential) cred).getIdentifier();     #2 - Start of 'try' block code snippet:       
                  if(validateUserAndPass()){  
                      System.out.println("Successfully logged in as "+username);       #3- Prints user successfully login info to console                    
                       return true;    }                          else {                   printInvalidLoginInfo();             return false;}                
                } catch (ExceptionInInitializerError e) {}  //Handling Exception                   
            }  
           throw new UnknownCredentialException("Unrecognized credential type");     #4 - Throws exception when unrecoginzed cntype   
        }                                                                       #5 End of 'validate' method implementation code snippet.        
             private boolean validateUserAndPass() {                      #6- Starts the function to check if login credentials match  
                 //Assuming we have some way in which user and pass are stored into a database (like hashing mechanism)    return true; } else  false;}       
               void printInvalidLoginInfo(){                                  #7 - Printing info about invalid username or password    
                  System.out.println("INVALID USERNAME OR PASSWORD");            throw new AssertionError();      }}