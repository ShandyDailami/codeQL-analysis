public class java_51402_SessionManager_A08 {    
  // Our list of users for this example (stores usernames/passwords). In a real application, you'd probably have stored the data in an actual database or other form where it can be accessed and updated easily via queries instead.     
   private static Map<String, String> userList = new HashMap<>();    
  // Adding some users for testing purpose (you should not use this way to store passwords!)        
    public java_51402_SessionManager_A08() {         
       userList.put("user1", "password");          
      }           
  
// This function is used by the client-side code       
public boolean login(String username, String pass) throws Exception{            
  // First check if a session exists (could be null or not). If it does then end this request.        
    Session s = getSession();         
     if(!s.isEmpty()) {                 return false; }     
   /* We are using the hashcode and equals methods for simplicity, but they should never actually used in a real application due to potential security risks such as timing attacks */       
  // Then we can check password (hashed) against what's stored about this user.           if(pass==null || !userList.containsKey("username")|| (!passwordEncoder().matches(plainPassword, encodedPassword))) throw new Exception();      return true; }        
   public static void main(){    try {        SessionManager sm =new  SessionManager ();     boolean loginSuccessful=sm .login (" user1 "," password ");       if(!loginSuccessful) System.out.println("Login Failed"); else System. out. println(“ Login Successfully” );   }catch({e:Exception}){SystemOutPrintLn+’‘  e};    
}    // This is the end of our program and should not be run directly to avoid runtime errors!          });