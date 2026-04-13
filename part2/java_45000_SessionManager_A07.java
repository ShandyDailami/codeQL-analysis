import java.util.*;

public class java_45000_SessionManager_A07 {    
    private Map<String, String> userMap = new HashMap<>(); // User names and passwords in memory 
  
    public void start() {}     
      
    /** Register a username to the system */       
    public boolean register(String name) throws Exception{         if (userMap.containsKey(name)) {             throw new Exception("User already exists");              } else          userMap.put(name, "password");            return true;      } 
  
       /** Try to log in a username and password */        public boolean login(String name , String pass) throws Exception{         if (!userMap.containsKey(name)) {             throw new Exception("User not found.");              } else          // compare the stored hash of user's pwd with this one               return pass.equals((char[])userMap.getOrDefault(name, "").toCharArray());      } 
  
}    public static void main (String args []) {        SessionManager sm = new SessionManager();           try{sm .register("alice");         if (!sm .login ("bob", "wrongpassword")) throw new Exception() ;            System.out.println(sm . login  ("Alice","password"));}catch