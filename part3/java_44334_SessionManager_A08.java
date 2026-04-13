import java.util.*;
public class java_44334_SessionManager_A08 {  
    private static Map<String, User> mapUsers = new HashMap<>(); // simulate database 
    
    public void addUser(User u) throws Exception{         
        if (mapUsers.containsKey(u.getUsername())) throw new Exception("This username already exists");           
         else mapUsers.put(u.getUsername(), u);   }      
     
  // retrieve user by its name    public User getUserByName(String login) throws InterruptedException{        return (mapUsers .containsKey()) ? null : new User("", "", false, true,"");     }}`          end of code snippet. I apologize if it was not as creative and realistic in your original request!