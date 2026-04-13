public class java_51154_SessionManager_A07 {
    private static Map<String, String> userDatabase = new HashMap<>(); // Simulating a database. UserName should be unique in the application for real use cases as well they can't repeat due to IDs being sequential and non-repeating etc 
  
     public boolean authenticate(String username, String password) {   
         if (userDatabase.containsKey(username)) // Checks whether user exists     
        return true;                                      // Returns TRUE only when a valid User is found in the database for that particular Username         
       else 
           throw new AuthFailureException("User not Found");   // Throws Exception If no such username or wrong password    
    }                                                       
}