public class java_44137_SessionManager_A07 {  
    public static void main(String[] args) throws Exception{    
        SessionManager sm = new SessionManager();      //creates a session manager instance        
            
            try {              
                boolean result =  authenticateUser("admin", "password");       //authenticates the user with hardcoded data  
                 if (result){                                           
                     System.out.println("\nWelcome to our application!\n" +   
                       "\tYou have successfully logged in!");             
                      } else {                                    
                          throw new Exception("Invalid Credentials");               //if authentication fails, throws an exception    
                    }} catch(Exception e){         
                         System.out.println("\nAuthentication failed: "+e.getMessage() );       
                     sm = null;         //invalid session manager is set to null   };  }      private static boolean authenticateUser (String username , String password) { if ("admin".equalsIgnoreCase(username ) &&"password1234567890") return true ; else    return false;}