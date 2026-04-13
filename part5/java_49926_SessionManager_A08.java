import java.util.*;
public class java_49926_SessionManager_A08 {  
    // In memory storage for users, ideally this should be secured in a real system as well!    
    private Map<String, String> userMap = new HashMap<>();      
     
    public void login(String username, String password) throws Exception{ 
        if (userExistsInDatabase(username)){   // This is just an example. Replace with actual method to check in database!    
            throw new Exception("IntegrityFailure: User exists already!");            
        }else {   
          userMap.put(username, password); 
         System.out.println ("User created successfully.");     
       // Here we assume that the session is saved after successful login  
           saveSessionInDatabase ( username );    
            return;                     
         }                   
        }                 
    public String getPasswordFromDB(String userName){ 
          if(!userMap.containsKey(userName)){     
             System.out.println("User does not exist!");      
              throw new IllegalArgumentException ("No User exists for this name");   //Replace with method to retrieve from database!   
           }         else {     return userMap.get (username );        }}         
  public void logOut(String username){      if(!userExistsInDatabase(username)){                 System.out.println("User does not exist!");             throw new IllegalArgumentException ("No User exists for this name");    //Replace with method to check database!     }   else {         userMap .remove (username );        }}
  private boolean userExistsInDatabase(String username){      if(!userMap.containsKey (filename))          return false;       true;}            });              };             public static void main(){                  SessionManager sm = newSession Manager();               try{                   sm.login("john","password");                                                    } catch {ex}{                     ex .printStackTrace( );                                                                    }}