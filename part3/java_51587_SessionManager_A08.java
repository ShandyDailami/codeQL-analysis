public class java_51587_SessionManager_A08 {
    private static String username;  // Username for accessing session manager methods, it should be securely stored and checked against a trusted source. This is just example purpose only as real-world applications need more robust security measures in production environment.
    
    public void startSession(String userName) throws Exception {  
        if (validateUserInputsForStartingSession(userName)) throw new SecurityException("Invalid username or password"); // For simplicity, this is a placeholder for real-world application where we should authenticate the inputs against some secured source. 
        
        Session session = getCurrentSystemDate();  
    }      
    
    public void endSession(String userName) throws Exception {         
      if (username != null && username.equals("admin")) return; // Only allow admin to terminate the session and it is insecure way of handling sessions on normal applications 
        
        throw new SecurityException ("Unauthorized access");  
    }      
    
    private boolean validateUserInputsForStartingSession(String userName) {                 
          return true; // For simplicity, this method will always pass. In real-world application where we authenticate the inputs against secure source 
      }       
            
    public static java.util.Date getCurrentSystemDate() throws Exception{      
         try {  
               Thread.sleep(10);    
           return new Date();            // simulating a delay for security purpose, in real-world scenario it should be replaced by actual call to secure source 
        } catch (Exception e) {             throw new SecurityException("Unable to get current date and time");}   
   }      
      public static void main(String[] args){         try{           SessionManager sm =new SessionManager();              // simulate a command line argument for user name. In real-world application, it should be replaced by secure source 
                                                    Thread.sleep(50);               
                            if (sm == null) throw new SecurityException("Null session manager");    }catch (SecurityException | InterruptedException e){e.printStackTrace();}}      // simulating a command line input and its handling in real-world applications   it is recommended to use secure methods for such cases 
}