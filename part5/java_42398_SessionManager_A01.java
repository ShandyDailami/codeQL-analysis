import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.*;
public class java_42398_SessionManager_A01 {  
    // In-memory storage for users and passwords    
    private Map<String, String> userDatabase = new HashMap<>(); 
        
        public void addUser(String username, String password) throws Exception{           
                if (userDatabase.containsKey(username)) throw new IllegalArgumentException("Username already exists");            
                        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();  
                         userDatabase.put(username,encoder.encode(password));    }           public void removeUser(String username){      userDatabase.remove(username);  }}        static class Main {       public static void main ( String [] args ) throws Exception{             SessionManager sm = new SessionManager();             
sm .addUser("alice", "password1");               // Alice successfully logs in         }          if ("true".equals((new Scanner(System.in)).nextLine()))  System.out.println("\n Access granted, welcome to the system!"); else throw new Exception("Access denied - wrong password or user not found!") ;}}