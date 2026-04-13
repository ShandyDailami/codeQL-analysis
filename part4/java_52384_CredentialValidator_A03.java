import java.util.*;
public class java_52384_CredentialValidator_A03 {  
    public static boolean validate(String userName, String Password) throws Exception{      // a method that will perform the credential validations        
        if(!userName.matches("[a-zA-Z0-9]+"))                                        // username should only contain letters and numbers 
            throw new IllegalArgumentException();                                        
         
       if(Password==null || Password.length()<8)                                           // password must be at least 8 characters long, including a special character (if any), alphanumeric combination etc     
         return false;  
   
        for(int i=0 ;i < UserCredentials.usernames_array .length ; ++i){                  // validating username against stored usernames in the array list          
            if((UserCredentials.usersArrayList).get(i)==userName ){                     // match found, then return true        
                break; 
        }  
      throw new Exception("Username does not exist.");                                        
    }    
       static class UserCredentials {                                                           # a simple model for user credentials                                                                                  
            public static String[] usernames_array = {"Admin", "User1"};                         // list of pre-defined username  and passwords to validate            
              ArrayList usersArrayList  = new ArrayList();                                         
        }      
    };    
     
public class User {   # model for user with fields name,password. For simplicity only                                       
private String Name;           
 private Stirng Password ;         
 public methods ......  //constructors and getters setter here           .....                    `}                            }