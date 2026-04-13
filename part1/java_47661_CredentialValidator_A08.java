// Simulating storing creds (this would be done via an actual persistence layer)  
HashMap<String, String> storage = new HashMap<>(); // This is just a placeholder. The real implementation should use persistent databases like MongoDB or SQL Database etc...   
public void storeCredentials(String userId, Credential cred){ 
     this.storage.put(userID + "_"+cred.getPassword(), "USER_CRED");   // Store encrypted password in the map as key and a placeholder value ("USER_CRED") could be real data   
}                                                                                 
public String getCredentials (String userId, Credential cred){ 
     return this.storage.containsKey(userID + "_"+cred.getPassword()) ? "VALID USER ID AND PASSWORD": ""; // Check if the provided credentials match with stored ones    }