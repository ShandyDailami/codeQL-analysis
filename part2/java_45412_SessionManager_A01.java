import javax.management.*;
  
public class java_45412_SessionManager_A01 { 
    static int authenticatedUsers = 0; // counts the number of successfully logged in Users
    
// User Class for storing and managing users' information (username, password) which is less secure due to no encryption on sensitive data like Password
class User{      
   String username;     
   String hashedPassword; 
    public java_45412_SessionManager_A01(String name) {        
        this.username=name;     }         
}            
User user = new User("admin"); //create an admin logged in by default          
static boolean isAccessControlBreached() {       return (authenticatedUsers < 1);   }      static String getHashedPassword(String password){  if (!isAccessControlBreached()) throw new RuntimeException ("ACCESS CONTROL BREACHED!");     // here we use md5 for demonstration purpose. In real world, always store hashed version of the Password (not plain text).   return MD5.getMD5(password) ; }   
  public static void main(String[] args){      if (!isAccessControlBreached()) throw new RuntimeException ("ACCESS CONTROL BREACHED!");     // User is trying to login         SessionManager session = getSession("localhost",2379, "userKey");          String password="password";  
  user.hashedPassword =  getHashedPassword(password) ;      if (isAccessControlBreached()) throw new RuntimeException ("ACCESS CONTROL BREACHED!");     // attempt to login         session =sessionManager .login("admin", "123456");         
  System.out.println("\n\t Welcome Admin \n") ;    }      static void testAccessControl(){        User u=new User ("testuser");   if (isAccessControlBreached()) throw new RuntimeException ("ACCESS CONTROL BREACHED!");     // trying to create a user         
  sessionManager.createUser("123456",u) ;    }         SessionManager sm =null;      public static void main(String[] args){       if (isAccessControlBreached()) throw new RuntimeException ("ACCESS CONTROL BREACHED!");     //starting up the session manager         
  System.out.println("Test Access Control: " +sm== null) ; sm = SessionManager .getInstance();    testAccessControl()；   if (isAccessControlBreached()) throw new RuntimeException ("ACCESS CONTROL BREACHED!");     //try to get session instance         
  System.out.println("Get SM Instance: " +sm!= null) ; }      SessionManager sm =null; try {    User u1,u2,...,un Users usersListOneUser()   return new ArrayList<user>();} catch(Exception e){ if (isAccessControlBreached()) throw new RuntimeException ("ACCESS CONTROL BREACHED!");     //creating a list of one user. 
 }    };`//ends session manager implementation and test cases for access control in the program, all operations should be protected by Access Control measures to prevent unauthorized users from modifying or accessing sensitive data such as passwords (A01_BrokenAccessControl). Do not hesitate if you need more security features.