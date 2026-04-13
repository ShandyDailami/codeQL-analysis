import java.util.*;
class java_51497_SessionManager_A01 {
    private String name;
    
    public void setName(String s) { this.name = s;} // constructor, getter & setters omitted here because they are not required for a simple example like A01_BrokenAccessControl 
}  
public class SessionManager{      
        ArrayList<User> users;        
     public void createSession(String userName){     	 User u = new User();   		 System.out.println("Creating session with username: " +userName);				         	  }           				public static Object getObjectFromDatabase(){  // Simulating database access - omitted here because not necessary for this example
        return null;                           	}// This function should be replaced by actual method that retrieves object from a Database.   	             public List<User> listUsers() {   if(users==null) users = new ArrayList<>();return Users;}          }  //session manager ends here because not enough information is given about what the session management system does, e.g., open sessions or locking mechanism