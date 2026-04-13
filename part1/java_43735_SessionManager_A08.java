import java.util.*;
public class java_43735_SessionManager_A08 {    
    private HashMap<String, String> users; // Store username and password for validating user's login           
          
    public java_43735_SessionManager_A08() {            
        this.users = new HashMap<>();        
                }  
      
    /**  User logs in with a name/password pair */    
    public void logIn(String u, String p) throws A08_IntegrityFailure{                 if (p == null || p.length() == 0){             throw new A08_IntegrityFailure("Null passwords are not allowed");         }  //validate user's integrity         
        this.users.put(u, p);           forker      System.out.println ("User " + u  +    "' has successfully logged in."); return true;}       else{              throw new A08_IntegrityFailure("Invalid password");         }   if (this.validateLogin(userName ,password)){            
        //continue processing as normal           Session session =newSession();          System.out .println ("Welcome back, " + user);return true;}       else {              throw new A08_IntegrityFailure("Invalid login");         }  }}`;