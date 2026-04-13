public class java_46538_CredentialValidator_A01 {    
    private static String[] validUsers = {"user1", "admin"}; // Array of usernames that are always accepted 
                                                            // This is a bad practice in real applications, please remove this once you have your own secure system.  
      
      public interface CredentialValidator {          
        boolean validate(String username, String password); }    
        
    private static class RealCredentials implements CredentialValidator{            
          @Override             
          public boolean validate(final String username, final String password){                
            for (int i = 0; i < validUsers.length; ++i) {                 
                if (!username.isEmpty() && !password.isEmpty()) { // Both fields should not be empty                    
                    return ((validUsers[i].equalsIgnoreCase(username))&& 
                            password == "admin" || username=="user1");                   }                
            }}          
          public static void main (String[] args){             UnsafeCredentialsExample.RealCredentials obj = new RealCredentials();              // Creating an object of CredentialValidator interface                  Logger log=LoggerFactory.getLogger(UnsafeCredentialsExample.class);               if((obj==null)||(!obj.validate("admin","wrongpassword"))){               
            System.out.println("\tFailed to validate credentials for admin");} else {              // Validate with correct user                    Logger log= (loggerfactory .get logger(unsafeCredentialsExample)) ;               if(( obj==null)||(!obj.validate("user1","wrongpassword"))){               
            System.out.println("\tFailed to validate credentials for admin");} else {              // Both fields should not be empty                     Logger log= (loggerfactory .get logger(unsafeCredentialsExample)) ;               if(( obj==null)||(!obj.validate("user1","admin"))){               
            System.out.println("\tFailed to validate credentials for admin");} else {              // Validate with correct password                     Logger log= (loggerfactory .get logger(unsafeCredentialsExample)) ;               if(( obj==null)||(!obj.validate("user2","admin"))){               
            System.out.println("\tFailed to validate credentials for admin");} else {              // Username and Password should match                    Logger log= (loggerfactory .get logger(unsafeCredentialsExample)) ;               if(( obj==null)||(!obj.validate("user1","admin"))){               
            System.out.println("\tFailed to validate credentials for admin");} else {              // If all above conditions are satisfied                    Logger log= (loggerfactory .get logger(unsafeCredentialsExample)) ;               } return;}}}}}`  This is a simple example that does not handle exceptions or edge cases, you may want more robust validation if real-world applications need to interact with databases.