import java.util.*;  // Import utilities like List, Map etc...  
                   // If we want a fixed list of users with different roles then use this import instead above line   
class java_48291_SessionManager_A01 {     // Define 'User' as an entity which will have properties - username and password (for simplicity)       
 String name;     
 /* For Hashing mechanism purpose only */ 
 public boolean validate(String pwd){  
       return true;                       
 }                              
}                     
public class SessionManager {     // Define 'Session Manager' as a manager which will handle sessions   
 List<User> users = new ArrayList<>();      // This is our list of all the registered Users. For simplicity, only username and password are used here        
 /* Function to create session for user */  
 public void start(String name) throws Exception {          // It's a function that will attempt 'starting/creating an Session'. Only valid users can access this method     
  User u = new User();   
  if(!u.validate("password")){     /* Check for the password of user */        
   throw new Exception ("Authentication Failed");       // If not a registered username or incorrect Password then we will say so          }           else {              System.out.println(name + " is logged in successfully.");      }}  public void modifyData() throws Exception{     /* Function to change data of user */        
 User u = new User();    if(!u.validate("password")) // If not a registered username or incorrect Password then we will say so          else {              System.out.println(name + " is trying修改数据");      }}  public static void main (String args []) throws Exception{      
 SessionManager sm = new SessionManager();     /* Create an instance of our session manager */        User u1=new User() ;   //Create user object    set details and try to start the sessions. For simplicity, here only username is used for login purpose          }  catch(Exception e){            System.out.println("Caught exception: " +e);     }}