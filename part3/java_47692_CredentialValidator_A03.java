import org.apache.commons.validator.*;
  
public class java_47692_CredentialValidator_A03 {
    public static boolean validateCredentials(String userName, String passWord) throws ExceptionInvalidArgumentsException{        
        // Check if username and passwords are not null or empty         
        if (userName == null || userName.isEmpty()){           
             throw new IllegalArgumentException("Username cannot be blank"); 
                   }               
                 else if(passWord==null|| passWord.isEmpty()) {             
                     throw new ExceptionInvalidArgumentsException ("Password field is required.");         
         }  
                  // Create a validator object to validate username and password            
        ICommonValidator commonVal = new UCommonValidator();   
                   String userNamePattern =  "^[A-Za-z0-9]{6,12}$";      
                 if(!commonVal.validate(userNamePattern , userName)) {              
                      throw  new ExceptionInvalidArgumentsException("Username must be alphanumeric with a length of at least six characters to no more than twelve");           }             
                  String passWordpattern = "^[A-Za-z0-9]{6,12}$";          if(!commonVal.validate(passWordpattern , passWord)) {                 throw new ExceptionInvalidArgumentsException("Password must be alphanumeric with a length of at least six characters to no more than twelve");             }    
                  // Check the entered username and password against predefined valid users   return commonVal.isValidUsername(userName) &&  (commonVal . isMatchingPassword() );              }}