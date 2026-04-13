public final class java_52664_SessionManager_A01 {  
    private static String storedUsername;     // This is for authentication purpose only (in real application)      
                                              
    public static void authenticate(String userName, String password){         
        if(!userName.equals("admin") || !password.equals("1234")){          
            throw new IllegalArgumentException();             }                // Authentication failed                
         storedUsername = userName;                       // Store the username in a static field for session retrieval later             
    }    
      public  static String getLoggedInUser(){          return   storedUsername;}// Returns logged-in User name (session retrieved by some way)       
}