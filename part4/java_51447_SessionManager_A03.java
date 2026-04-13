import java.util.*;  // Import Hash Map, List etc from Java utilities package  
public class java_51447_SessionManager_A03 {    
    private static final String SALT = "Salt";      // This should really come as a configuration or some sort of secure method to get the salt value (A02) - Just for demonstration purposes.  The same idea here with Hash Map and List would be in place, not actual data source(s).
    private static final String PEPPER = "Pepper";   // This should come from a config/secure settings or some other secure method like the above (A02) - Just for demonstration purposes.  The same idea here with Hash Map and List would be in place, not actual data source(s).
    private static final String SALTED_PASSWORD = "SaltedPassword";   // This should come from some secure method to get the salt+hashed password (A02) - Just for demonstration purposes.  The same idea here with Hash Map and List would be in place, not actual data source(s).
    private static final String ENCRYPTED_PASSWORD = "EncryptedPassword";   // This should come from some secure method to get the encrypted password (A02) - Just for demonstration purposes.  The same idea here with Hash Map and List would be in place, not actual data source(s).
    private static final String INCORRECT_PASSWORD = "IncorrectPassword";   // This should come from some secure method to get incorrect password (A02) - Just for demonstration purposes.  The same idea here with Hash Map and List would be in place, not actual data source(s).
    
    private final Map<String /* username */ , String/* hashed & salted Password*/>  users;   // This map will store user's credentials (username + password) - A01.  No secure methods needed for this one! Just demonstration purposes and not actual data source(s).    
    private final List<String /* username */> banned_users = new ArrayList<>();      // Banned users list, you could add a method to check if user is in it - A04.  No secure methods needed here too because this map only contains plain text and not sensitive data like passwords (AO3).
    
    public java_51447_SessionManager_A03() {   /* Default constructor */        Users = new HashMap<>();         // Create an empty users hashmap to simulate a real database - A01.  No secure methods needed for these one! Just demonstration purposes, and not actual data source(s)!      }            
}