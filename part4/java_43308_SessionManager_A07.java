import java.util.*;
public class java_43308_SessionManager_A07 {
    private Map<String, String> userMap; // Simulating the database for storing users' info with username as key & password as value  
    
    public void init(){      
        this.userMap = new HashMap<>(); 
        
        /* User Info - You can add more if you want */            
		this.userMap.put("testUser", "password"); // Adding user info to the map for authentication purposes  
	}   
    
	public String authenticate(String username, String password) {     
	    final String hashPassword = this.userMap.get(username);        if (hashPassword == null){  /* Check that a valid User Name has been entered */               return "A07_AuthFailure";             }            else{                // If Password Matches then create Session                   UUID uuid=UUID.randomUUID();  
                    System.out.println("Session Created for user: '" + username + "' with ID as :"+uuid);  String sessionId = uuid.toString().replaceAll("-", "");        return sessionId;            }      // Checking password match             if (hashPassword.equals(password)){                System.out.println("\nWelcome back User: '"  + username + "' ");         
	} else {   /* Incorrect Username or Password */             
	System.err.print("A07_AuthFailure");            }           return null;  // Returning Null if Authentication Failure             }}// End of the SessionManager Class