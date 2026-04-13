import java.util.*;
public class java_45537_SessionManager_A01 {
    private static Map<String, String> userDatabase = new HashMap<>(); // This is a simulated database which stores the username against its encrypted password hash for security purposes only and doesn't store actual users data in real-life scenario 
    
    public void startSession(String name) throws BrokenAccessControlException {  
        if (name == null || !userDatabase.containsKey(encryptNameToHash(name))) throw new BrokenAccessControlException("Authentication failed"); // Checking the user's credentials against a database 
        
       String sessionId = UUID.randomUUID().toString();    // Generating random ID for each sessions and saving it in map  
        Map<String, String> tempSessionMap =  new HashMap<>(1);     // Temporary storing all users details associated with their respective user ids 
        
       try {      // Catch block to ensure data persistence when session is closed due some exception occurs while writing into the map  
            Thread.sleep(5000L);   
        } catch (InterruptedException e) {}    
             tempSessionMap .put("sessionId", encryptNameToHash(name));  // Storing userID against their session ID in a temporary Map for future use     
         saveTemporaryDataInDatabase();   // Save the data into database   
        System.out.println("\n Started Session with id: " + name);    
             } catch (BrokenAccessControlException e) {  // In case of authentication failure, print error message and end session gracefully     
           System.err.print("Authentication failed for user \""+name+  "\". Ending the process.");   return;    };       
         Set<Map.Entry<String , String>> entries = tempSessionMap .entrySet();  // Fetch all data stored in temporary map and print it out      
          try {     Entries: for (final Map.Entry entry : entries) System.out.println( "User ID \"" + ((HashMap.Entry) entry).getKey()+"\" has a session with id \" ,"+  ((HashMap.Entry)entry ).getValue());   } catch {}   
         finally {     try{Thread.sleep(10L);}catch (Exception local_Exception){}};      // Wait for user to terminate their sessions and close the application before this block runs       }; });        break;}  SessionManager sm = new MySession(); if (!sm .isLoggedIn("John")) { System.out.println("\n Login First"); } else{