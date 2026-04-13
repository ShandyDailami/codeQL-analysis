import javax.security.auth.*;
// Import for the CredentialAccessException, LoginException etc... 
   // These exceptions will be thrown when there are problems with authentication or authorization.   
    
public class java_49157_CredentialValidator_A01 {     
       public boolean validate(String userName , String password) throws AuthenticationException{         
             if (userName == null || password==null){              
                   throw new NullPointerException("User Name and Password cannot be null.");            }             
         // Add some checks to verify the username is valid. This could depend on your application's requirements, e.g., checking length of string etc...  .  
             if (userName == ""){               throw new IllegalArgumentException ("Username can not empty");      
        }}           
          else {              // If everything checks out we return true to sign in the user        
                  System.out.println("User has been authenticated successfully."); }  };     public class Main   {      static void main(String[] args) throws Exception{               SecureServer server = new SecureServer();                   try{                                                    String username="abc";                //replace with actual user details                
          String password  = "xyz123$";             }catch (Exception e){                       System.out.println("Error occurred: ");                     }}            });  };