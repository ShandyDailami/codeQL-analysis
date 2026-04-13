import javax.security.auth.*;
public class java_51750_CredentialValidator_A01 {    
         public boolean authenticate(String userName, String password) throws AuthenticationException{        //a method to validate the username and password     
            if (userName == null || password == null){               
                 throw new NullPointerException("Username or Password is missing");         
             }             
              
           else {                     
                    try {                       
                         Security.getLoginModule( userName , password );                       //authenticate the credentials                           
                          return true;                                                                  //credentials are valid     
                     } catch ( UnavailableException e ){                                                              //catch exception for unsupported module      
                               System.out.println("Unable to Authentication: " +e);                        
                                  return false;                                                    //return invalid        
                             }  
                          finally {                                                                  //close the loginModule     
                                   Security.clearLoginModule();    
                              }}          catch ( InvalidCredentialException e1 ){              //catch exception for wrong password       
                                         System.out.println("Invalid Password: " +e1);             #return invalid   
                                        return false;                                          
                                      }  finally {                                                                  
                                                Security.clearLoginModule();                         };         });     }} ;                 ^_^                      '