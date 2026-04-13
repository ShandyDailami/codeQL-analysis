import java.util.*;   // Import ArrayList for dynamic operations, HashMap to handle user data as key-value pairs etc., and other necessary imports   
public class java_42720_CredentialValidator_A07 {    
        public static void main(String[] args) {      
            Map<String , String> validUsers = new HashMap<>(); 
             /* Adding users in the map */  
              validUsers.put("user1","password1");      //Valid User   
              validUsers.put("admin", "master@1234567890!");//Admin user with strong password      
            CredentialValidator cv = new MyCredentialValidation();     /* Instance of the class */  
             System.out.println(cv.isValidUserNameAndPassword("user1", "password1"));  //Prints true if valid else false   
              try {     
                  System.out.println ( cv . isValidUserNameAndPassword ("admin","wrong password")) ;   /* Password wrong */    
                   } catch(AuthFailure e) {       //Catching the exception and printing error message 
                      System. out . println("Authentication failed: " +e);        };   
                }}