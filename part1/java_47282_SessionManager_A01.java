public class java_47282_SessionManager_A01 {
    private String token; //This field holds the actual information of a logged in user. In real use case, it should be encrypted as well to prevent session hijacking or leaks about who's signed into what account etc.. This is just for simplicity and understanding purpose on this example  
} 
public class SessionManager {    
    private HashMap<String, UserSession> sessions = new HashMap<>(); //This map will hold all the user session information. In a real use case scenario, it could be backed by database or other persistent store like Hazelcast etc.. It's just for simplicity and understanding purpose on this example  
    
    public void createSession(User user) { 
        String token = UUID.randomUUID().toString(); //Create random session (token). In real use case, it should be encrypted to secure against brute-force attacks etc.. This is only used for simplification and understanding purpose on this example  
       sessions.put(user.getUsername(), new UserSession()); 
    }    
      public void validateToken(String token) { //Method will check if the given session (token), exists in our map of users with valid tokens, or not? This is mainly to secure against brute-force attacks etc.. In real use case scenario this would be based on encryption/decryption using a secret key for example.
        sessions.containsKey(token);  //Check if the token (session) exists in our map of users with valid tokens, or not? This is mainly to secure against brute-force attacks etc.. In real use case scenario this would be based on encryption/decryption using a secret key for example.
      }    
}