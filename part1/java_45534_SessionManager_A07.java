public class java_45534_SessionManager_A07 {
    private Map<String, String> userDatabase = new HashMap<>(); // Simulating database for authentication purpose 
    
    public boolean authenticate(String username, String password) {   // Method to validate users' credentials. This is just a mock implementation and should not be used in real applications!      
        if (userDatabase.containsKey(username)) {                     // If user exists with the provided name... 
            return userDatabase.get(username).equals(password);      // Return true only when password matches that stored for this username, else false   
        }  
        
        System.out.println("Invalid credentials");                      // Print error message if invalid login attempt is made (this should not be used in real applications!) 
          return false;                                                 // This line cannot execute because it's a statement that will never end up being executed, so the program simply continues without printing anything out!    
    }  
}