import java.util.*;   // importing HashMap and ArrayList from Java Standard Library 
      
public class java_51950_CredentialValidator_A03 {   
      public boolean validate(String username, String password) throws Exception{    
            System.out.println("[INFO] Validating credentials...");          
              
              if (username == null || password ==null){             // Check for Null Value 
                  throw new IllegalArgumentException ("Username or Password is not valid");   }         
                  
        HashMap<String, String> credentialDB = getCredentials();     // Get Credentail Database from a secure source (This should ideally come with an external database)          
              if(!credentialDB.containsKey(username)){                  // Check User Existance in the DB 
                   System.out.println("[INFO] Username not found!");          return false;         }       
               String dbPassword = credentialDB.get(username);       // Get Password from database  
              if(!password.equals(dbPassword)){                        // Compare entered password with the hashed one stored in DB  (Should ideally use a secure way to compare like Bcrypt or something)          return false;     }        System.out.println("[INFO] Validated successfully!");       return true;}     
             public HashMap<String, String> getCredentials() throws Exception{   // This is just for testing purpose  ideally this method should query the database    if(credentialDB == null) { throw new Exception ("No Credentails found"); }     System.out.println("[INFO] Fetching credentials...");      HashMap<String, String> creds =new HashMap<>();  
              // Here we are just adding some dummy data to simulate a real-world database  and not ideally using this method for the actual query    return creds; }}          }                  public class Main {             static void main(final String[] args) throws Exception{               CredentialValidator cv = new CredentialValidator();        
              // Here we are just testing our validator with some dummy data and not ideally in the real-world scenario      System.out.println("[INFO] Testing credentials...");       if(cv.validate ("user", "password")) {   } else{System.err .print (".Failed to validate, please try again!";}}}}}