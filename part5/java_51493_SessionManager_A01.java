import java.util.*;  // Import required collections library  
   
public class java_51493_SessionManager_A01 {    
      private Map<String, String> userDB;        // User Database (Hashmap)         
        
       public void createUserDatabase(){             this.userDB = new HashMap<>();              }          
           
                protected boolean authenticate(final String username , final String password ){                  if(!this.userDB.containsKey(username)){                    System.out.println("No such user found."); return false;               }                 else {                     // Check the Password                   if (!passwordEncryptionService().matches ( this.userDB.get ( key ), encryptedPassword ))               
{System. out . println ("Invalid Credentials" );return false;}                         }}          private boolean passwordMatcher(final String userName, final Object enteredPassword) {           // Method to check Password Matching         if (!this.passwordEncryptionService().matches ( this.userDB.get ( key ), encryptedEnteredPass)) 
{System . out . println ("Invalid Credentials" );return false;}                      return true;}}          public void addUser(final String username, final String password) {                // Method to Add new User                  userPassword =this.passwordEncryptionService().encrypt ( encryptedLoginPin); this.userDB.put (username , userPassWord  ) ;              }